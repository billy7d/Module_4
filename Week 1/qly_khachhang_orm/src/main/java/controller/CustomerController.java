package controller;


import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import service.ICustomerService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    ICustomerService customerService;

    @GetMapping("/")
    public String list(Model model){
        ArrayList<Customer> customers = (ArrayList<Customer>) customerService.findAll();
        model.addAttribute("list",customers);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("/student/edit/{id}")
    public String showUpdateForm(@PathVariable("id") int id,Model model){
        Customer customer = customerService.findById(id);
        model.addAttribute("customer",customer);
        return "edit";
    }
    @PostMapping("/edit")
    public String update(Customer customer,Model model){
        customerService.update(customer);
        List<Customer> customers = customerService.findAll();
        model.addAttribute("list",customers);
        return "index";
    }

    @GetMapping("/student/delete/{id}")
    public String delete(@PathVariable("id") int id){
        customerService.remove(id);
        return "redirect:/";
    }

}
