package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.domain.LoginInfo;
import com.mytodolist.springtodo.domain.TodoDTO;
import com.mytodolist.springtodo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;

@Log4j2
@Controller
@RequestMapping("/todo/register")
public class TodoRegisterController {

    private final TodoService todoService;

    public TodoRegisterController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public void getRegistForm(){

        log.info("regist get ... ");

    }

    @PostMapping
    public String postTodoRegist(@Valid TodoDTO todoDTO,
                                 BindingResult bindingResult,
                                 HttpServletRequest req){

        if(bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
            return "redirect:/todo/register";
        }

        log.info("regist post ... " );

        String todo = req.getParameter("todo");
        String dueDate = req.getParameter("dueDate");
        String finished = req.getParameter("finished");

        log.info(todo);
        log.info(dueDate);
        log.info(finished);

        LoginInfo loginInfo = (LoginInfo) req.getSession().getAttribute("loginInfo");

        log.info(loginInfo.getUserID());

        // 사용자가 입력한 데이터 받아오기

        try {
            todoService.registToList(todoDTO, loginInfo.getUserID());
        } catch (SQLException e){
            e.printStackTrace();
        }

        return "redirect:/todo/list";
    }
}
