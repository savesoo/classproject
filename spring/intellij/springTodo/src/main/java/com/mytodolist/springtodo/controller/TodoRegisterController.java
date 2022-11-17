package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.domain.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Log4j2
@Controller
@RequestMapping("/todo/register")
public class TodoRegisterController {


    @GetMapping
    public void getRegistForm(Model model){

        model.addAttribute("todoList", "no");
        log.info("regist get ... ");
    }

    @PostMapping
    public String postTodoRegist(@ModelAttribute("todoList") TodoDTO todoDTO){

        log.info("todo : " + todoDTO );


        return "redirect:/todo/list";
    }
}
