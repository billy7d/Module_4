package controller;

import model.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("counter")
public class CountController {

    @ModelAttribute("counter")
    public Counter setUpCounter(){
        return new Counter();
    }

    @GetMapping("/")
    public String getCounter(@ModelAttribute("counter") Counter counter){
        counter.increaseCount();
        return "index";
    }
}
