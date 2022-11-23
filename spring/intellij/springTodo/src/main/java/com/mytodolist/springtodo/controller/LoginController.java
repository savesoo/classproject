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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public void getLoginForm() {

        log.info("login get ... ");

    }

    @PostMapping
    public String postLogin(@ModelAttribute UserDTO userDTO, HttpServletRequest req, RedirectAttributes redirectAttributes) {

        log.info("login post ... ");

        try {

            UserDTO user = service.loginByIDPW(userDTO.getUserID(), userDTO.getUserPW());

            if (user != null) {
                HttpSession session = req.getSession(); // 세션 생성
                session.setAttribute("loginInfo", user.toLoginInfo()); // 이 데이터만 가지고 다닐 것

                return "redirect:/user/myInfo";

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        log.info("login fail notmatch ... ");
        return "redirect:/user/login?fail=notmatch";

    }
}
