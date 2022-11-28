package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.domain.UserDTO;
import com.mytodolist.springtodo.service.UserLoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
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

    private final UserLoginService userService;

    public LoginController(UserLoginService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getLoginForm(HttpSession session) {

        log.info("login get ... ");

        // Session이 null이 아닌 경우=로그인 상태일 때는 다른 페이지로
        if(session.getAttribute("loginInfo")!=null){
            return "redirect:/user/myInfo";
        }

        // null인 경우
        return "user/login";

    }

    @PostMapping
    public String postLogin(@ModelAttribute UserDTO userDTO,
                            BindingResult bindingResult,
                            HttpServletRequest req,
                            HttpServletResponse res,
                            RedirectAttributes redirectAttributes) {

        log.info("login post ... ");

        if(bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
            return "redirect:user/login";
        }


        HttpSession session = req.getSession(); // 세션 생성

        try {

            // 로그인
            UserDTO user = userService.loginByIDandPW(userDTO.getUserID(), userDTO.getUserPW());

            if(user==null){
                log.info("login fail notmatch ... ");
                return "redirect:/user/login?fail=notmatch";
            }

            log.info(user);

            String rememberMe = req.getParameter("rememberMe");

            // 자동로그인 on체크시 처리 부분
            if(rememberMe!=null && rememberMe.equals("on")){

                // uuid 쿠키에 저장하고 문자열 형태로 DB에 업데이트
                UUID uuid = UUID.randomUUID();
                log.info("uuid = " + uuid);
                Cookie c = new Cookie("uuid", uuid.toString());
                c.setMaxAge(60*60*24);
                c.setPath("/");
                res.addCookie(c);

                // 현재 로그인한 사용자 저장
                userService.updateUUID(uuid.toString(), user.getUser_idx());

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
