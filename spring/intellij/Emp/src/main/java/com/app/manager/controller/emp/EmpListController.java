package com.app.manager.controller.emp;

import com.app.manager.service.emp.EmpListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("emp/list")
public class EmpListController {

    @Autowired(required = false)
    private EmpListService empListService;

    @GetMapping
    public void getEmpList(Model model){
        log.info("get empList >>>> ");
        model.addAttribute("emplist", empListService.getEmpList());
    }

}
