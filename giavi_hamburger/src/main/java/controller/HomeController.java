package controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
    String result1 =" ";

@GetMapping("/")
    public String showPage(){
    return "index";
}

@PostMapping("/save")
public String save(@RequestParam("sauce") String [] condiment, Model model){

    for (int i = 0; i < condiment.length; i++) {
        result1 += condiment[i] + ",";
    }

    model.addAttribute("result",result1);
    return "index";

}

}
