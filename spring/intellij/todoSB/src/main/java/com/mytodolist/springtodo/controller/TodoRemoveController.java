package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.domain.LoginInfo;
import com.mytodolist.springtodo.domain.TodoDTO;
import com.mytodolist.springtodo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Log4j2
@Controller
@RequestMapping("/todo/remove")
public class TodoRemoveController {

    private final TodoService todoService;

    public TodoRemoveController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public String postRemove(@RequestParam("tno") int tno, HttpServletRequest req){

        log.info("remove post ... ");

        try {

            LoginInfo loginInfo = (LoginInfo) req.getSession().getAttribute("loginInfo");
            TodoDTO todo = TodoDTO.builder().tno(tno).userID(loginInfo.getUserID()).build();
            todoService.removeTodo(todo);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return "redirect:/todo/list";
    }


}
