package com.app.manager.controller;

import com.app.manager.service.EmpDeleteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("/emp/delete")
public class EmpDeleteController {

    @Autowired(required = false)
    private EmpDeleteService empDeleteService;

    @GetMapping
    public String deleteEmp(@RequestParam("empno") int empno){

        log.info(" post delete >>>> ");
        empDeleteService.deleteEmp(empno);
        return "redirect:/emp/list";
    }
}
