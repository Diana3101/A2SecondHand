package com.example.demo.entities;

import javax.persistence.*;
import java.util.UUID;


@Entity
public final class Staff{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String firstName;
    private String lastName;
    private double salary;
    private String position;

    public Staff(){

    }

    public Staff(String firstName, String lastName, double salary, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition(){
        return position;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    @Override
    public String toString() {
        return "ID: " + id + "; First Name: " + firstName + "; Last Name: " + lastName + "; " + "I`m a " + position + "; my salary: " + salary + ".";
    }
}

