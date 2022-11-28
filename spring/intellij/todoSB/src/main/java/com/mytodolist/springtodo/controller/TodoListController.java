package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.domain.LoginInfo;
import com.mytodolist.springtodo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Log4j2
@Controller
@RequestMapping("/todo/list")
public class TodoListController {

    private final TodoService todoService;

    public TodoListController(TodoService service){
        this.todoService = service;
    }

    @GetMapping
    public void getAllList(Model model, HttpServletRequest req){

        log.info("list get ...");

        LoginInfo loginInfo = (LoginInfo) req.getSession().getAttribute("loginInfo");

        model.addAttribute("todoList", todoService.getAllList(loginInfo.getUserID()));

    }


}
