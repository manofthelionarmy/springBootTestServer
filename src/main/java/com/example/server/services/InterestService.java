package com.example.server.services;

import com.example.server.interests.Interests;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InterestService {

    private static AtomicLong counter = new AtomicLong();

    //returns all interests
    public @ResponseBody Interests retrieveAllInterests(HttpServletResponse response){
        System.out.println("insert");
        Interests i = new Interests(counter.getAndIncrement(), "art");
        return i;
    }

    //returns a single interest
    public void retrieveInterest(){}

    //updates a single interest
    public void updateInterest(){}

    //creates a single interest
    public void createInterest(){}

    //deletes a single interest
    public void deleteInterest(){}
}
