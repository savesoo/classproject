package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Log4j2
@Controller
@RequestMapping("/todo/remove")
public class TodoRemoveController {

    private final TodoService service;

    public TodoRemoveController(TodoService service) {
        this.service = service;
    }

    @PostMapping
    public String postRemove(@RequestParam("tno") int tno){

        log.info("remove post ... ");

        try {
            service.removeTodo(tno);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "redirect:/todo/list";
    }


}
