package com.example.demo.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "addedBy", cascade = CascadeType.ALL)
    private List<Thing> addedClothing;
    private SellerWish wish;

    public Seller(){

    }

    public Seller(String firstName, String lastName, List<Thing> addedClothing, SellerWish wish) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.addedClothing = addedClothing;
        this.wish = wish;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddedClothing(List<Thing> addedClothing) {
        this.addedClothing = addedClothing;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public List<Thing> getAddedClothing(){
        return addedClothing;
    }

    public SellerWish getWish(){
        return wish;
    }

    public void setWish(SellerWish wish){
        this.wish = wish;
    }

    public void addThingToList(Thing thing){
        addedClothing.add(thing);
    }

    @Override
    public String toString() {
        return "Seller{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", addedClothing=" + addedClothing +
                ", wish=" + wish +
                '}';
    }
}
