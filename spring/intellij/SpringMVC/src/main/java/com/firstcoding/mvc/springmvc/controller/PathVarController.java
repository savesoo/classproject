package com.firstcoding.mvc.springmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
public class PathVarController {

    // 경로의 일부분을 변수처럼 사용하는 PathVariable

    // http://localhost:8080/member/1
    // http://localhost:8080/member/22
    // http://localhost:8080/member/13

    @RequestMapping("/members/{type}/{idx}") // {}안을 변수처럼 사용
    public String getMemberInfo(@PathVariable("type") String type,
                                @PathVariable("idx") String idx, Model model){

        log.info("type = " + type);
        log.info("idx = " + idx);
        model.addAttribute("idx", idx);

        return "/info";
    }
}
