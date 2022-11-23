package com.mytodolist.springtodo.controller;

import com.mysql.cj.Session;
import com.mytodolist.springtodo.domain.LoginInfo;
import com.mytodolist.springtodo.domain.TodoDTO;
import com.mytodolist.springtodo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Log4j2
@Controller
@RequestMapping("/todo/register")
public class TodoRegisterController {

    private final TodoService service;

    public TodoRegisterController(TodoService service) {
        this.service = service;
    }

    @GetMapping
    public void getRegistForm(){

        log.info("regist get ... ");

    }

    @PostMapping
    public String postTodoRegist(@ModelAttribute("todoList") TodoDTO todoDTO, HttpServletRequest req){

        log.info("regist post ... " );

        String todo = req.getParameter("todo");
        String dueDate = req.getParameter("dueDate");
        String finished = req.getParameter("finished");

        LoginInfo loginInfo = (LoginInfo) req.getSession().getAttribute("loginInfo");

        // 사용자가 입력한 데이터 받아오기

        try {
            service.registToList(todoDTO, loginInfo.getUserID());
        } catch (SQLException e){
            e.printStackTrace();
        }

        return "redirect:/todo/list";
    }
}
