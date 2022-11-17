package com.mytodolist.springtodo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/user/login")
public class LoginController {

    @GetMapping
    public void getLoginForm(){

    }

    @PostMapping("/todo/list")
    public String login(){

        return "redirect:/todo/list";
    }
}
