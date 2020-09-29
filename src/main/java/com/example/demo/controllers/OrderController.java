package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Order;
import com.example.demo.entities.Seller;
import com.example.demo.entities.Thing;
import com.example.demo.entities.dto.CreateOrderDTO;
import com.example.demo.entities.dto.OrdersDTO;
import com.example.demo.services.OrderService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> show(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping({"id"})
    public ResponseEntity<Order> showById(@PathVariable UUID id) throws NotFoundException{
        return ResponseEntity.ok(orderService.getOrderById(id));
    }


    @PostMapping
    public ResponseEntity<Order> create(@RequestBody CreateOrderDTO createOrder){
        Seller seller = createOrder.getSeller();
        Customer customer = createOrder.getCustomer();
        List<Thing> things = createOrder.getThings();
        orderService.addOrder(seller, things, customer);
        return ResponseEntity.ok().build();
    }


}
