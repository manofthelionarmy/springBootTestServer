package com.example.server.controller;

import com.example.server.greetings.Greeting;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@RestController
public class GreetingController {


    private static ArrayList<Greeting> g = new ArrayList<Greeting>();


    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();



    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(required = false, value = "name", defaultValue = "World") String name){
        if( g.isEmpty()){
            g.add(new Greeting(counter.get(), String.format(template, name)));
        }

        return g.get(0);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/greeting")
    public ResponseEntity<?> updateUser(@RequestBody Greeting greeting){

        Greeting update = new Greeting(greeting.getId(), greeting.getContent());
        /*if(greeting == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }*/
        g.clear(); g.add(update);
        if(greeting.getId() == 0){
            System.out.println("found " + update.getContent());
        }
        return new ResponseEntity<Greeting>(update, HttpStatus.OK);
    }



}
