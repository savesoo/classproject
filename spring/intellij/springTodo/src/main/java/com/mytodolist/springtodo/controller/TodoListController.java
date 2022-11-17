package com.mytodolist.springtodo.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/todo/list")
public class TodoListController {

    @GetMapping
    public void getAllList(Model model){

        model.addAttribute("todoList", "list");

        log.info("list get ...");

    }


}
