package com.app.board.auth;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class LoginController {

    @GetMapping("/auth/login")
    public void login(){
        log.info("login");
    }
}
