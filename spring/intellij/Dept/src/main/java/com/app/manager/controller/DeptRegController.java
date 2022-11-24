package com.app.manager.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/dept/register")
public class DeptRegController {

    @GetMapping
    private void getRegForm(){

    }


    @PostMapping
    public String reg(){
        return "redirect:/dept/list";
    }
}
