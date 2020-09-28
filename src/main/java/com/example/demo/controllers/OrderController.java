package com.example.demo.controllers;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Seller;
import com.example.demo.entities.Thing;
import com.example.demo.entities.dto.CreateOrderDTO;
import com.example.demo.entities.dto.OrdersDTO;
import com.example.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("create")
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderDTO createOrder){
        Seller seller = createOrder.getSeller();
        Customer customer = createOrder.getCustomer();
        List<Thing> things = createOrder.getThings();
        orderService.addOrder(seller, things, customer);
        System.out.println(seller);
        return ResponseEntity.ok().build();
    }

    @GetMapping("getAll")
    public @ResponseBody
    OrdersDTO getAllOrders(){
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.setOrders(orderService.getAllOrders());
        return ordersDTO;
    }
}
