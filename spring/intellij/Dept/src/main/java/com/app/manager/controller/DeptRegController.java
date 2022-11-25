package com.app.manager.controller;

import com.app.manager.domain.DeptDTO;
import com.app.manager.service.DeptRegService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

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
    public String reg(@Valid DeptDTO deptDTO, BindingResult bindingResult){

        log.info("post reg ... ");
        log.info(deptDTO);

        // 체크한 결과값 확인 = 에러 있는지?
        if(bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
            for(ObjectError objectError : bindingResult.getAllErrors()){
                log.info(objectError.getCodes()[1] + " : " + objectError.getDefaultMessage());
            }
        }

        service.insertDept(deptDTO);
        //service.insertDepts(deptDTO);
        return "redirect:/dept/list";

    }
}
