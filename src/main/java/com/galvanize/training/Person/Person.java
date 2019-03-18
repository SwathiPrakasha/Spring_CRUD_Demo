package com.galvanize.training.Person;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person {


    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    public Person(){

    }

    public Person(String fName, String lName, int age){
        this.firstName=fName;
        this.lastName=lName;
        this.age=age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
