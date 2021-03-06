package com.example.msafirstservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/first-service")
public class FirstController {

    private final Environment env;


    @GetMapping("/welcome")
    public String greeting() {
        return "first controller.";
    }

    @GetMapping("/header")
    public String header(@RequestHeader("first-request") String header) {
        return header + " first controller.";
    }

    @GetMapping("/check")
    public String check(HttpServletRequest request) {
        log.info("Server port={}", request.getServerPort());

        return String.format("check from first controller. port is %s", env.getProperty("local.server.port"));
    }
}
