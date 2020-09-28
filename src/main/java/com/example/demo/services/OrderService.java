package com.example.demo.services;

import com.example.demo.entities.*;
import com.example.demo.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final ThingRepository thingRepository;
    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final StorageRepository storageRepository;
    private final SellerRepository sellerRepository;

    @Autowired
    public OrderService(ThingRepository thingRepository, OrderRepository orderRepository, CustomerRepository customerRepository, StorageRepository storageRepository, SellerRepository sellerRepository) {
        this.thingRepository = thingRepository;
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.storageRepository = storageRepository;
        this.sellerRepository = sellerRepository;
    }

    @Transactional(readOnly = true)
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Transactional
    public void addOrder(Seller seller, List<Thing> requiredThings, Customer customer){
        List<Thing> toOrder = new ArrayList<>();
        Seller sellerToOrder = sellerRepository.findSellerByName(seller.getFirstName(), seller.getLastName());
        for(Thing th: requiredThings){
            Thing thing = thingRepository.findThingByName(th.getName());
            Storage thingItem = storageRepository.findByThing(thing);
            if(thingItem == null){
                continue;
            }
            int thingQuantity = thingItem.getQuantity();
            if(thingQuantity > 0){
                toOrder.add(thing);
                int newQuantity = thingQuantity - 1;
                thingItem.setQuantity(newQuantity);
                storageRepository.save(thingItem);
            }else {
                storageRepository.delete(thingItem);
            }
        }
        if(toOrder.size() > 0){
            Order order = new Order(toOrder, sellerToOrder, customer);
            customerRepository.save(customer);
            orderRepository.save(order);
        }
    }
}

