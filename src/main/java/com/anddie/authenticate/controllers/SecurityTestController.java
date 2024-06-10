package com.anddie.authenticate.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityTestController {

    @GetMapping("/test")
    public String testUrl(){
        return "Hello World this is security test";
    }
}
