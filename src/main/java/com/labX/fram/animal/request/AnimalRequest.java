package com.labX.fram.animal.request;

import com.labX.fram.data.Request;

public class AnimalRequest implements Request {

    private String type;

    public AnimalRequest(){
    }

    public AnimalRequest withType(final String type){
        this.type = type;
        return this;
    }
    
    public String getType() {
    	return type;
    }
}
