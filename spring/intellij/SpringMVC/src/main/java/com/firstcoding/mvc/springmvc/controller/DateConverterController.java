package com.firstcoding.mvc.springmvc.controller;

import com.firstcoding.mvc.springmvc.domain.UserRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;

@Log4j2
@Controller
@RequestMapping("/date")
public class DateConverterController {

    // @GetMapping = 하위버전일시 기본 매핑 -> 세부 전송형태 지정
    @RequestMapping(method = RequestMethod.GET)
    public String getDateForm(){
        return "dateForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String date(LocalDate date,
                       UserRequest userRequest,
                       Model model){

        // 커맨드 방식
        model.addAttribute("date", date);
        return "date";

    }
}
