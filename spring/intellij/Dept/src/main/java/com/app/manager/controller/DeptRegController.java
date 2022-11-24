package com.app.manager.controller;

import com.app.manager.domain.DeptDTO;
import com.app.manager.service.DeptRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/dept/register")
public class DeptRegController {

    @Autowired
    private DeptRegService service;

    @GetMapping
    private void getRegForm(){

        log.info("get regForm ... ");

    }


    @PostMapping
    public String reg(DeptDTO deptDTO){

        log.info("post reg ... ");
        log.info(deptDTO);

        service.insertDept(deptDTO);
        return "redirect:/dept/list";

    }
}
