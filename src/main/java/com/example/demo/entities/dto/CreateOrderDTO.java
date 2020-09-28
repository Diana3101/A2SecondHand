package com.example.demo.entities.dto;

import com.example.demo.entities.Customer;
import com.example.demo.entities.Seller;
import com.example.demo.entities.Thing;

import java.util.List;

public class CreateOrderDTO {

    private Seller seller;
    private Customer customer;
    private List<Thing> things;

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Thing> getThings() {
        return things;
    }

    public void setThings(List<Thing> things) {
        this.things = things;
    }


}
