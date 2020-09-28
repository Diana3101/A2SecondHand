package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Thing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private NameofThing name;
    private Size size;
    private ConditionOfThing condition;
    private double price;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    @JsonBackReference
    private Seller addedBy;

    public Thing() {

    }


    public Thing(NameofThing name, double price, Size size, ConditionOfThing condition, Seller addedBy) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.condition = condition;
        this.addedBy = addedBy;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(NameofThing name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public ConditionOfThing getCondition() {
        return condition;
    }

    public void setCondition(ConditionOfThing condition) {
        this.condition = condition;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Seller getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(Seller addedBy){
        this.addedBy = addedBy;
    }
    public double getPrice(){
        return price;
    }

    public NameofThing getName(){
        return name;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "id=" + id +
                ", name=" + name +
                ", size=" + size +
                ", condition=" + condition +
                ", price=" + price +
                ", addedBy=" + addedBy +
                '}';
    }
}
