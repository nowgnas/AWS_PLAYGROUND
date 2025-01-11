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

    @GetMapping("guess/{req}")
    public ResponseEntity<String> guess(@PathVariable String req) {
        try {
            int number = Integer.parseInt(req);

            if (number < 1 || number > 100) {
                return ResponseEntity.ok().body("1부터 100 사이의 숫자를 입력해 주세요!! ");
            }
            LocalDate today = LocalDate.now();
            int answer = (today.getYear() + today.getMonthValue() * today.getDayOfMonth()) % 100;
            if (number > answer) {
                return ResponseEntity.ok().body("아쉽네요.. down!!");
            } else if (number < answer) {
                return ResponseEntity.ok().body("아쉽네요.. up!!");
            } else {
                return ResponseEntity.ok().body("정답입니다!!");
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body("1부터 100 사이의 숫자를 입력해 주세요!! ");
        }
    }
}
