package com.example.server.services;

import com.example.server.greetings.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {




    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();


    public Greeting greeting(@RequestParam(required = false, value = "name", defaultValue = "World") String name){
        Greeting g = new Greeting(counter.get(), String.format(template, name));
        return g;
    }

    public ResponseEntity<Greeting> updateUser(Greeting greeting){

        Greeting update = new Greeting(greeting.getId(), greeting.getContent());

        if(greeting.getId() >= 0){
            System.out.println("found " + update.getContent());
        }
        return new ResponseEntity<Greeting>(update, HttpStatus.OK);
    }
}
