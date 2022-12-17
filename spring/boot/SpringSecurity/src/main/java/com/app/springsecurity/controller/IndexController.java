package com.app.springsecurity.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class IndexController {



    @GetMapping("/")
    public String index(){
        return "redirect:index";
    }

}