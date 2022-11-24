package com.app.manager.controller;

import com.app.manager.domain.EmpDTO;
import com.app.manager.service.EmpEditService;
import com.app.manager.service.EmpReadService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("emp/edit")
public class EmpEditController {

    @Autowired(required = false)
    private EmpReadService empReadService;

    @Autowired(required = false)
    private EmpEditService empEditService;

    @GetMapping
    public void getEditForm(@RequestParam("empno") int empno, Model model){
        log.info("get emp editForm >>>> ");
        model.addAttribute("saved", empReadService.selectByEmpno(empno));
    }

    @PostMapping
    public String postEdit(EmpDTO empDTO){
        log.info("post edit >>>> ");
        log.info(empDTO);

        empEditService.updateEmp(empDTO);

        return "redirect:/emp/list";

    }



}
