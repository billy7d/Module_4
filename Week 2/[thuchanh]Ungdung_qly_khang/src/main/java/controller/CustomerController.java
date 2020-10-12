package controller;


import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import service.CustomerService;

import java.util.List;

@Controller
public class CustomerController {

@Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public String findAll(Model model){
        List<Customer> customers =customerService.findAll();
        model.addAttribute("customers",customers);
        return "index";
    }
}
