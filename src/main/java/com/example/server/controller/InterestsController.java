package com.example.server.controller;

import com.example.server.interests.Interests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.server.services.InterestService;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


@RestController
public class InterestsController {

    @Autowired
    private InterestService interestService;

    private ArrayList<Interests> i = new ArrayList<Interests>();


    // GET: will get the whole list of the interests
    public void getAllInterests(){}


    //GET: gets a single interest
    @CrossOrigin("http://localhost:4200")
    @GetMapping("/interests")
    public @ResponseBody List<Interests> getInterest(HttpServletResponse response){
        response.setContentType("application/json");
        if(i.isEmpty()){

            i.add(interestService.retrieveAllInterests(response));
        }
        for(Interests j: i){
            System.out.println(j.getInterests());
        }
        return i;
    }

    //PUT: updates a single interest
    public void updateInterest(){}

    //DELETE: deletes a single interest
    public void deleteInterest(){}

    //POST: saves a single interest
    public void saveInterest(){}
}
