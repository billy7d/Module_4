package controller;


import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {


    @ModelAttribute("user")
    public User setUserSession() {
        return new User();
    }

    @RequestMapping("/login")
    public String Index(User user, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                        HttpServletRequest request, HttpServletResponse response, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookieValue", cookie);
        return "login";
    }

    @PostMapping("/dologin")
    public String doLogin(User user, Model model, @CookieValue(value = "user", defaultValue = "") String user1,
                          HttpServletRequest request, HttpServletResponse response) {
        //implement business logic
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("123")) {
            if (user.getEmail() != null) {
                user1 = user.getEmail();
            }

            // create cookie and set it in response
            Cookie cookie = new Cookie("User", user1);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);

            //get all cookies
            Cookie[] cookies = request.getCookies();
            //iterate each cookie
            for (Cookie ck : cookies) {
                //display only the cookie with the name 'setUser'
                if (ck.getName().equals("User")) {
                    model.addAttribute("cookieValue", ck);
                    break;
                } else {
                    ck.setValue("");
                    model.addAttribute("cookieValue", ck);
                    break;
                }
            }
            model.addAttribute("message", "Login success. Welcome ");
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", user1);
            model.addAttribute("cookieValue", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "login";
    }


}
