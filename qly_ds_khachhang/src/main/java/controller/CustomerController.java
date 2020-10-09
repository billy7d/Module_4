package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CustomerController {
    private CustomerService customerService =  CustomerServiceFactory.getInstance();

    @GetMapping("/customers")
    public String showList(HttpServletRequest request){
       List<Customer> customers = customerService.findAll();
       request.setAttribute("customer",customers);

        return "customer/list.jsp";
    }
}
