package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.domain.TodoDTO;
import com.mytodolist.springtodo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/todo/modify")
public class TodoModifyController {

//    private final TodoService service;
//
//    public TodoModifyController(TodoService service){
//        this.service = service;
//    }


    @GetMapping
    public void getModifyView(){

        log.info("Modify get ...");

    }


    @PostMapping("/todo/modify")
    public String postModify(@ModelAttribute TodoDTO todoDTO){

        log.info("Modify post ...");

        return "redirect:/todo/list";

    }
}
