package com.example.aws.test;

import java.time.LocalDate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("test/content")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("hello spring boot");
    }

    @GetMapping("guess/{number}")
    public ResponseEntity<String> guess(@PathVariable int number) {
        LocalDate today = LocalDate.now();
        int answer = (today.getYear() + today.getMonthValue() * today.getDayOfMonth()) % 100;
        if (number == answer) {
            return ResponseEntity.ok().body("정답입니다!!");
        } else {
            return ResponseEntity.ok().body("아쉽네요.. 틀렸습니다!");
        }
    }
}
