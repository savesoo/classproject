package com.mytodolist.springtodo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/user/myInfo")
public class MyInfoController {

    @GetMapping
    public void getMyInfoPage(){
        log.info(" MyInfo get ... ");
    }

    @PostMapping
    public String postMyInfo(){

        log.info(" MyInfo post ... ");
        return "redirect:/todo/list";

    }
}
