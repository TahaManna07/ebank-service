package ma.enset.ebankservice.web;

import lombok.AllArgsConstructor;
import ma.enset.ebankservice.entities.Customer;
import ma.enset.ebankservice.repositories.CustomerRepository;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerGraphQlController {
    private CustomerRepository customerRepository;


    @QueryMapping
    public List<Customer> customerList(){
        return customerRepository.findAll();
    }
}
