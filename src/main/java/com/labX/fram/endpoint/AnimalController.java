package com.labX.fram.endpoint;

import javax.json.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.labX.fram.animal.component.AnimalComponent;
import com.labX.fram.animal.request.AnimalRequest;
import com.labX.fram.component.ComponentNameResolver;
import com.labX.fram.component.ComponentFactory;

@RestController
public class AnimalController {

    @Autowired
    private ComponentFactory componentFactory;
    
    @GetMapping(path="/v1/read/animals", produces = "application/json")
    public ResponseEntity<String> get(@RequestParam(value = "type", required = false) final String type){
        final AnimalComponent component = componentFactory.resolve(ComponentNameResolver.resolve("animal"));
        JsonObject result = component.readAll(new AnimalRequest().withType(type));
        return ResponseEntity.ok().body(result.toString());
    }
}
