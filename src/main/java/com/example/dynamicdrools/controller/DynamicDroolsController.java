package com.example.dynamicdrools.controller;

import com.example.dynamicdrools.service.DynamicDroolsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DynamicDroolsController {
    @Autowired
    private DynamicDroolsService dynamicDroolsService;

    @GetMapping("/")
    public ResponseEntity<List<String>> getFields() {
        return new ResponseEntity<>(dynamicDroolsService.getFields(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> instantiateClass(@RequestBody String json) throws Exception {
        return new ResponseEntity<>(dynamicDroolsService.instantiateClass(json), HttpStatus.OK);
    }
}
