package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.domain.LoginInfo;
import com.mytodolist.springtodo.domain.TodoDTO;
import com.mytodolist.springtodo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

@Log4j2
@Controller
@RequestMapping("/todo/modify")
public class TodoModifyController {

    private final TodoService todoService;

    public TodoModifyController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping
    public void getModifyView(Model model, @RequestParam("tno") int tno, HttpServletRequest req){

        log.info("Modify get ...");

        try{
            LoginInfo loginInfo = (LoginInfo) req.getSession().getAttribute("loginInfo");
            TodoDTO todo = TodoDTO.builder().tno(tno).userID(loginInfo.getUserID()).build();
            model.addAttribute("todo", todoService.getTodoByTno(todo));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @PostMapping
    public String postModify(@ModelAttribute("todo") TodoDTO todoDTO, HttpServletRequest req){

        log.info("Modify post ...");

        try {
            LoginInfo loginInfo = (LoginInfo) req.getSession().getAttribute("loginInfo");
            todoService.updateTodo(todoDTO, loginInfo.getUserID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/todo/list";

    }
}
