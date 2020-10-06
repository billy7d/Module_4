package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/index")
    public String index(@RequestParam("usd") double usd, Model model){
        double vnd = usd*23000;
        model.addAttribute("vnd",vnd);
        return "index";
    }

}
