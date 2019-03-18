package com.galvanize.training.Person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepo;

    //returns all persons in db
    @GetMapping("/persons")
    public List<Person> getPersons() {
        List<Person> people = new ArrayList<>();
        personRepo.findAll().forEach(people::add);
        return people;
    }

    //return a person with same id
    @GetMapping("/persons/getUser/{id}")
    public Person getPersonById(@PathVariable("id") int id) {
        return personRepo.findById(id).get();
    }

    //Create an user
    @PostMapping("/persons/createUser")
    public Person postAddPerson(@RequestBody Person person) {
        return personRepo.save(person);
    }

    //update an user by id using put
    /*@PutMapping("/persons/updateUser/{id}")
        public Person updatePersonById( @RequestBody Person person, @PathVariable("id") int id){

        //Optional is container to hold object that is not null
//        Optional<Person> personOptional = personRepo.findById(id);
//
//        if(!personOptional.isPresent()){
//            return ResponseEntity.

        Person currentPerson = personRepo.findById(id).get();
        currentPerson.setFirstName(person.getFirstName());
        currentPerson.setLastName(person.getLastName());
        currentPerson.setAge(person.getAge());
        return personRepo.save(person);
        }
*/
    //update an user with post
    @PostMapping("/persons/updateUser")
    public Person updatePersonBy(@RequestBody Person person){
        return personRepo.save(person);
    }

        //delete an user by id
        @DeleteMapping("/persons/deleteUser/{id}")
        public String deletePersonById ( @PathVariable("id") int id){
        //Optional is container to hold object that is not null
        Optional<Person> personOptional = personRepo.findById(id);

        if(!personOptional.isPresent()){
                return "No User found";
            }
            personRepo.deleteById(id);
            return "User Deleted successfully";
        }


}


