package com.app.manager.controller;

import com.app.manager.domain.EmpDTO;
import com.app.manager.service.EmpRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/emp/regist")
public class EmpRegController {

    @Autowired
    private EmpRegService empRegService;

    @GetMapping
    public void getRegForm(){
        log.info(" get emp regForm >>>> ");
    }

    @PostMapping
    public String postRegist(Model model, EmpDTO empDTO){

        log.info("post regist >>>> ");
        log.info(empDTO);

        model.addAttribute(empRegService.insertEmp(empDTO));
        return "redirect:/emp/list";
    }
}
