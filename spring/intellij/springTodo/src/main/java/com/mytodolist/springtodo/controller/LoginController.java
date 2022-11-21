package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.dao.UserDao;
import com.mytodolist.springtodo.domain.UserDTO;
import com.mytodolist.springtodo.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Log4j2
@Controller
@RequestMapping("/user/login")
public class LoginController {

    private final UserService service;

    public LoginController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public void getLoginForm(){

        log.info("login get ... ");

    }

    @PostMapping
    public String postLogin(@ModelAttribute UserDTO userDTO, HttpServletRequest req) {

        log.info("login post ... ");

        String userID = req.getParameter("userID");
        String userPW = req.getParameter("userPW");

        HttpSession session = req.getSession(); // 세션 생성

        boolean isLogin = false;

        try {

            isLogin = service.loginByIDPW(userDTO);
            session.setAttribute("loginInfo", userID);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (isLogin) {
            return "redirect:/todo/list";
        } else {
            log.info("login fail notmatch ... ");
            return "redirect:/user/login?fail=notmatch";
        }

    }
}
