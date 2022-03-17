package com.example.msafirstservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first-service")
public class FirstController {
    @GetMapping("/welcome")
    public String greeting() {
        return "first controller.";
    }

    @GetMapping("/header")
    public String header(@RequestHeader("first-request") String header) {
        return header + " first controller.";
    }

    @GetMapping("/check")
    public String check() {
        return "check from first controller.";
    }
}
