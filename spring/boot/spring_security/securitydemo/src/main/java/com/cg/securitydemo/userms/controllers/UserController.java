package com.cg.securitydemo.userms.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/success")
    public String loginSuccess(){
        return "successfully logged in";
    }

}
