package com.dsysme.community.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanerController {

    @RequestMapping("loaners")
    @GetMapping("{name}")
    public String sayHello(@PathVariable("name")String name) {
        return "Hello loaner!" + name;
    }
}
