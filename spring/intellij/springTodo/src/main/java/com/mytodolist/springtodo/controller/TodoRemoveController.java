package com.mytodolist.springtodo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/todo/list")
public class TodoRemoveController {

    @PostMapping
    public String postRemove(){

        return "redirect:/todo/list";
    }


}
