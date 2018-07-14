package com.dsysme.community.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanerController {

    @RequestMapping("loaners")
    public String sayHello() {
        return "Hello loaner!";
    }
}
