package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.domain.UserDTO;
import com.mytodolist.springtodo.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@Controller
@RequestMapping("/user/signup")
public class SignUpController {

    private final UserService service;

    public SignUpController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public void getSignup(){

        log.info(" signup get ... ");

    }

    @PostMapping
    public String postSignUpForm(@ModelAttribute UserDTO userDTO, MultipartHttpServletRequest req) {

        log.info(" signup get ... ");

        String userPW = req.getParameter("userPW");
        String checkPW = req.getParameter("checkPW");
        MultipartFile userProfile = req.getFile("userProfile"); // 파일 첨부

        log.info("userProfile = " + userProfile.getOriginalFilename());

        // web 경로
        String uploadURI = "/image";
        // 시스템 경로
        String dirRealPath = req.getSession().getServletContext().getRealPath(uploadURI);
        log.info(dirRealPath);
        // 저장
        try {
            userProfile.transferTo(new File(dirRealPath, userProfile.getOriginalFilename()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            service.signupTodoUser(userDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 비밀번호 확인
        if(userPW.equals(checkPW)) {
            return "redirect:/user/login?result=t";
        } else {
            return "redirect:/user/signup?fail=check";
        }

    }
}
