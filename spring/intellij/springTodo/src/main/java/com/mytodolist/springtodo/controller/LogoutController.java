package com.mytodolist.springtodo.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
@Controller
@RequestMapping("/user/logout")
public class LogoutController {

    @GetMapping
    public String getloginFormAfterLogout(HttpSession session){

        log.info("logout get ... ");

        session.invalidate();
        return "redirect:/user/login";

    }

}
