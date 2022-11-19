package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.domain.TodoDTO;
import com.mytodolist.springtodo.service.TodoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

@Log4j2
@Controller
@RequestMapping("/todo/modify")
public class TodoModifyController {

    private final TodoService service;

    public TodoModifyController(TodoService service){
        this.service = service;
    }


    @GetMapping
    public void getModifyView(Model model, @RequestParam("tno") int tno){

        log.info("Modify get ...");

        try{
            model.addAttribute("todo", service.getTodoByTno(tno));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @PostMapping
    public String postModify(@ModelAttribute("todo") TodoDTO todoDTO){

        log.info("Modify post ...");

        try {
            service.updateTodo(todoDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "redirect:/todo/list";

    }
}
