package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class DictionaryController {
    @GetMapping("/index")
    public String showPage(){
        return "index";
    }

    @PostMapping("/index")
    public String findWord(@RequestParam String word, Model model){
        HashMap hashMap = new HashMap();
        hashMap.put("dog","cho");
        hashMap.put("shit","cut");

        if (hashMap.containsKey(word)){
            model.addAttribute("wordDisplay",hashMap.get(word));
        }

        return "index";

    }

}
