package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.entities.dto.CustomerDTO;
import com.example.demo.services.CustomerService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public ResponseEntity<List<Customer>> show() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> showById(@PathVariable UUID id) throws NotFoundException {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody CustomerDTO dto) {
        Customer newCustomer = new Customer(dto.getFirstName(),
                dto.getLastName(), dto.getSize(), dto.getProblem());
        return ResponseEntity.ok(customerService.addCustomer(newCustomer));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) throws NotFoundException {
        customerService.deleteCustomerById(id);
        return ResponseEntity.noContent().build();
    }
}
