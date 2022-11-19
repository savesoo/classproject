package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.domain.TodoDTO;
import com.mytodolist.springtodo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Log4j2
@Controller
@RequestMapping("/todo/read")
public class TodoReadController {

    private final TodoService service;

    public TodoReadController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public void getTodoRead(Model model, @RequestParam("tno") int tno){

        // tno를 매개로 read view창 불러오기

        log.info("read get ... ");

        try {
          model.addAttribute("todo", service.getTodoByTno(tno));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
