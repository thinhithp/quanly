package com.example.demo.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TestQuerryController {
    @Autowired
    private TestQuerryService testQuerryService;

    @GetMapping("/test")
    public ResponseEntity<List<TestQuerry>> callTestQuerry() {
        testQuerryService.getTestQueries();
        return ResponseEntity.ok().build();
    }
}
