package com.app.manager.controller.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
@RequestMapping("/mc/simple")
public class SimpleConverterController {

    @GetMapping
    public void form(){
        log.info("form ... ");
    }

    // JSON 형식의 문자열이 응답으로 들어올 수 있다! 데이터를 받을 때도 JSON형식으로 받을 수 있다~
    @PostMapping
    @ResponseBody // return의 ""를 경로가 아닌 문자열 형식으로 body에 출력
    public String simple(@RequestBody String body){
        log.info("body >>>>>>> " + body);
        return "body >>>>>>> " + body;
    }

}
