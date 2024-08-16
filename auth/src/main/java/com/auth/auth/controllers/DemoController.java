package com.auth.auth.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/demo")
public class DemoController {

    @GetMapping("")
    public void demoResponse() {
        System.out.println("Hello from secure endpoint");
    }
}
