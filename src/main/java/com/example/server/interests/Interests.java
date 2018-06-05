package com.example.server.interests;

public class Interests {
    private long id;
    private String interests;

    public Interests(){}

    public Interests(long id, String interests){
        this.id = id;
        this.interests = interests;
    }

    public String getInterests() {
        return interests;
    }
    public long getId(){
        return id;
    }

}
