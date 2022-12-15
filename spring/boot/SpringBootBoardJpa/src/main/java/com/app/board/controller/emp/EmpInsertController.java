package com.app.board.controller.emp;

import com.app.board.domain.EmpDTO;
import com.app.board.service.emp.EmpInsertService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/emp/insert")
public class EmpInsertController {

    @Autowired
    private EmpInsertService empInsertService;

    @GetMapping
    public void insertEmp(){
    }

    @PostMapping
    public String getInsertPage(){

        EmpDTO empDTO = EmpDTO.builder().build();
        empInsertService.insertEmp(empDTO);

        return "redirect:/emp/list";
    }
}
