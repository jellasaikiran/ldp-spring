package com.ldp.springdemo.rest;

import com.ldp.springdemo.entity.Customer;
import com.ldp.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);
        if(customer == null){
            throw new CustomerNotFoundException("No customer found - "+customerId);
        }
        return customer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer){
        customer.setId(0);
        customerService.saveCustomer(customer);
        return customer;
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer){
        customerService.saveCustomer(customer);
        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId){
        Customer customer = customerService.getCustomer(customerId);
        if(customer == null){
            throw new CustomerNotFoundException("No customer found - "+customerId);
        }
        customerService.deleteCustomer(customerId);
        return "Deleted customer id - "+customerId;
    }
}
