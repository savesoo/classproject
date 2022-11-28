package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.domain.UserDTO;
import com.mytodolist.springtodo.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.UUID;

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
    public String postLogin(@ModelAttribute UserDTO userDTO,
                            HttpServletRequest req,
                            HttpServletResponse res,
                            RedirectAttributes redirectAttributes) {

        log.info("login post ... ");

        HttpSession session = req.getSession(); // 세션 생성

        try {

            // 로그인
            UserDTO user = service.loginByIDPW(userDTO.getUserID(), userDTO.getUserPW());

            if(user==null){
                log.info("login fail notmatch ... ");
                return "redirect:/user/login?fail=notmatch";
            }

            String rememberMe = req.getParameter("rememberMe");

            // 자동로그인 on체크시 처리 부분
            if(rememberMe!=null && rememberMe.equals("on")){

                // uuid 쿠키에 저장하고 문자열 형태로 DB에 업데이트
                UUID uuid = UUID.randomUUID();
                Cookie c = new Cookie("cookie", uuid.toString());
                c.setMaxAge(60*60*24);
                c.setPath("/");
                res.addCookie(c);

                // 현재 로그인한 사용자 저장
                service.updateUUID(uuid.toString(), user.getUser_idx());

            }

            // 로그인 성공
            session.setAttribute("loginInfo", user.toLoginInfo()); // 이 데이터만 가지고 다닐 것


        } catch (SQLException e) {
            e.printStackTrace();
        }

//        log.info("login fail notmatch ... ");
//        return "redirect:/user/login?fail=notmatch";
        return "redirect:/user/myInfo";

    }
}
