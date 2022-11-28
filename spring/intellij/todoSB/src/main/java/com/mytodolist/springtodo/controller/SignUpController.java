package com.mytodolist.springtodo.controller;

import com.mytodolist.springtodo.domain.SignUpDTO;
import com.mytodolist.springtodo.service.SingUpService;
import com.mytodolist.springtodo.service.UserLoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;

@Log4j2
@Controller
@RequestMapping("/user/signup")
public class SignUpController {

    private final UserLoginService userService;
    private final SingUpService singUpService;

    public SignUpController(UserLoginService service, SingUpService singUpService) {
        this.userService = service;
        this.singUpService = singUpService;
    }

    @GetMapping
    public void getSignup(){

        log.info(" signup get ... ");

    }

    @PostMapping
    public String postSignUpForm(@Valid SignUpDTO signUpDTO,
                                 BindingResult bindingResult,
                                 HttpServletRequest req) throws SQLException {

        log.info(" signup get ... ");

        log.info(signUpDTO);

        if(bindingResult.hasErrors()){
            log.info(bindingResult.getAllErrors());
            return "redirect:/user/signup";
        }

        String userPW = req.getParameter("userPW");
        String checkPW = req.getParameter("checkPW");

        log.info(userPW);
        log.info(checkPW);

        try {

            if(userPW.equals(checkPW)) {

                singUpService.checkFileAndSignUp(signUpDTO, req);

                return "redirect:/user/login?result=t";
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

         return "redirect:/user/signup?fail=check";


    }

}
