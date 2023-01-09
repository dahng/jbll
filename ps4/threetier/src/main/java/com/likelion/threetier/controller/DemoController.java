package com.likelion.threetier.controller;

import com.likelion.threetier.service.DemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final DemoService service;

    public DemoController(DemoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String getString() {
        return service.getString();
    }
}
