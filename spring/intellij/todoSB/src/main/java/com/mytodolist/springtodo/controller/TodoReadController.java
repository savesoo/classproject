package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.domain.LoginInfo;
import com.mytodolist.springtodo.domain.TodoDTO;
import com.mytodolist.springtodo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Log4j2
@Controller
@RequestMapping("/todo/read")
public class TodoReadController {

    private final TodoService todoService;

    public TodoReadController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public void getTodoRead(Model model, @RequestParam("tno") int tno, HttpServletRequest req){

        // tno를 매개로 read view창 불러오기

        log.info("read get ... ");

        try {
            LoginInfo loginInfo = (LoginInfo) req.getSession().getAttribute("loginInfo");
            TodoDTO todo = TodoDTO.builder().tno(tno).userID(loginInfo.getUserID()).build();
            model.addAttribute("todo", todoService.getTodoByTno(todo));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



}
