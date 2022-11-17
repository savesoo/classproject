package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.domain.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/todo/read")
public class TodoReadController {

    @GetMapping
    public void getTodoRead(){
        log.info("read get ... ");
    }

    @PostMapping
    public String postTodoRead(@ModelAttribute("todoList") TodoDTO todoDTO){

        log.info("read post ... ");

        log.info("todo : " + todoDTO );


        return "redirect:/todo/list";
    }


}
