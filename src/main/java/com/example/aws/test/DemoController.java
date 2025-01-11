package com.example.aws.test;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("test/content")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("hello spring boot");
    }
}
