package com.example.server.controller;




import com.example.server.greetings.Greeting;
import com.example.server.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    private static ArrayList<Greeting> g = new ArrayList<Greeting>();

    private Greeting greeting;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/greeting")
    public Greeting getGreetings(){
        if(g.isEmpty()){
            g.add(greetingService.greeting("World!"));
        }
        return g.get(0);
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/greeting")
    public void update(@RequestBody Greeting greeting){
        greetingService.updateUser(greeting);
        g.clear();
        g.add(greeting);
    }


}
