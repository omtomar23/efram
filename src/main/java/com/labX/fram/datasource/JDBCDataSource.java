package com.labX.fram.datasource;

import com.labX.fram.service.impl.SQLQuery;
import org.springframework.stereotype.Component;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import java.util.HashMap;
import java.util.Map;

@Component
public class JDBCDataSource {

    public JsonArray get(final SQLQuery query){
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        Map<String,Object> values = new HashMap<>();
        values.put("name","Buf-101");
        values.put("age",3);
        arrayBuilder.add(Json.createObjectBuilder(values).build());
        return arrayBuilder.build();
    }

}
