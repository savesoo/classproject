package com.firstcoding.mvc.springmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Log4j2
@Controller
@RequestMapping("/cookie")
public class CookieController {


    // 서버 쪽에서 쿠키값 확인 가능~ CookieValue로 매개변수 선언해서 쿠키값 가져오기
    @GetMapping("/view")
    public String viewCookie(@CookieValue("userName") String userName,
                             @CookieValue(name = "realist", defaultValue = "dreamer") String realist,
                             Model model,
                             @RequestHeader("referer") String referer){

        log.info("referer = " + referer); // redirect 용도로 사용
        log.info("realist = " + realist);
        log.info("userName = " + userName);
        model.addAttribute("cookieName", "userName");
        model.addAttribute("cookieValue", userName);

        return "cookie/view";
    }



    // Spring 내부에서의 쿠키 처리 -> response를 매개변수로 받음!
    @GetMapping("/make")
    public String makeCookie(HttpServletResponse response){ // response는 서비스에 전달 가능

        Cookie cookie = new Cookie("userName", "kim");
        cookie.setPath("/");
        cookie.setMaxAge(60*60);

        response.addCookie(cookie);

        return "cookie/make";
    }
}
