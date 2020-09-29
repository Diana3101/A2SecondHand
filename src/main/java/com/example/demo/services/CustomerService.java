package com.example.demo.services;

import com.example.demo.entities.Customer;
import com.example.demo.repo.CustomerRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    @Transactional
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @Transactional
    public Customer getCustomerById(UUID id)throws NotFoundException {
        Optional<Customer> tempCustomer = customerRepository.findById(id);
        if (tempCustomer.isPresent()){
            return tempCustomer.get();
        }
        else{
            throw new NotFoundException(String.format("Customer with id %s was not found", id));
        }
    }

    @Transactional
    public void deleteCustomerById(UUID id) throws NotFoundException{
        customerRepository.delete(getCustomerById(id));
    }



}
