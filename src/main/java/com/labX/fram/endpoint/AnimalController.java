package com.labX.fram.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.labX.fram.command.Command;
import com.labX.fram.command.CommandFactory;
import com.labX.fram.command.CommandNameResolver;
import com.labX.fram.request.Request;
import com.labX.fram.request.impl.AnimalSearchRequest;
import com.labX.fram.response.JsonDataset;

@RestController
public class AnimalController {

    @Autowired
    private CommandFactory commandFactory;
    @GetMapping(path="/v1/read/animals", produces = "application/json")
    public ResponseEntity<String> get(@RequestParam(value = "type", required = false) final String type){
        final Command<Request, JsonDataset> command = commandFactory.resolve(CommandNameResolver.resolve("search"));
        JsonDataset dataset = command.apply(new AnimalSearchRequest().withType(type));
        return ResponseEntity.ok().body(dataset.get());
    }
}
