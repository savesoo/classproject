package com.app.manager.controller.dept;

import com.app.manager.domain.DeptDTO;
import com.app.manager.service.dept.DeptRegService;
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
    private DeptRegService deptRegService;

    @GetMapping
    private void getRegForm(){

        log.info("get regForm ... ");

    }


    @PostMapping
    public String reg(DeptDTO deptDTO){

        log.info("post reg ... ");
        log.info(deptDTO);

        deptRegService.insertDept(deptDTO);
        return "redirect:/dept/list";

    }
}
