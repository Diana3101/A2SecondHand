package com.example.demo.controllers;

import com.example.demo.entities.dto.CustomerDTO;
import com.example.demo.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("getAll")
    public @ResponseBody
    CustomerDTO getAllCustomers(){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCustomers(customerService.getAllCustomers());
        return customerDTO;
    }
}
