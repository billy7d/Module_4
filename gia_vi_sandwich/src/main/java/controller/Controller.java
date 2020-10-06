package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping("/")
    public String showPage(){
        return "index";
    }

    @RequestMapping("/save")
    public String save(@RequestParam("condiment") String[] condiment){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("condiment",condiment);
        return "index";
    }

}

