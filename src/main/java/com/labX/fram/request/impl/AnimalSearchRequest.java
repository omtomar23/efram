package com.labX.fram.request.impl;

import com.labX.fram.request.Request;

public class AnimalSearchRequest implements Request {

    private String type;

    public AnimalSearchRequest(){
    }

    public AnimalSearchRequest withType(final String type){
        this.type = type;
        return this;
    }
    
    public String getType() {
    	return type;
    }
}
