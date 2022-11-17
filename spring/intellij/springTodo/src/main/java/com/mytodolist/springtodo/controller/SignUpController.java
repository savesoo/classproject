package com.mytodolist.springtodo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/user/signup")
public class SignUpController {

    @GetMapping
    public void getSignup(){

    }

    @PostMapping("/user/login")
    public String postLoginForm(){
        return "redirect:/user/login";
    }
}
