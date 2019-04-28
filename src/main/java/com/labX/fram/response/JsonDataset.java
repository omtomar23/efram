package com.labX.fram.response;

import javax.json.JsonArray;

public class JsonDataset implements Dataset<String> {

    private JsonArray jsonArray;
    public JsonDataset(JsonArray jsonArray){
        this.jsonArray = jsonArray;
    }

    @Override
    public String get(){
        return jsonArray.toString();
    }
}
