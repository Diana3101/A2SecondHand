package com.example.demo.entities;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    private Size size;
    private Problems problem;

    public Customer(){

    }

    public Customer(String firstName, String lastName, Size size, Problems problem) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.size = size;
        this.problem = problem;
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

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Problems getProblem(){
        return problem;
    }

    public void setProblem(Problems problem){
        this.problem = problem;
    }

    @Override
    public String toString(){
        return "ID: " + id + "; First Name: " + firstName + "; Last Name: " + lastName + "; " + "I`m a customer. " + "My size: " + size + ".";
    }
}
