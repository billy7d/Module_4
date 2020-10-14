package controller;


import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("customer",new Customer());
        return "create";
    }
    @PostMapping("/create/customer")
    public String createCustomer(Customer customer){
        customerService.save(customer);
        return  "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEdit(@PathVariable int id,Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "edit";
    }

    @PostMapping("/edit/customer")
    public String edit(Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        customerService.remove(id);
        return "redirect:/";
    }
}
