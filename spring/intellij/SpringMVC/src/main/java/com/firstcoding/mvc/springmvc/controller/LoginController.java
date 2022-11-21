package com.firstcoding.mvc.springmvc.controller;

import com.firstcoding.mvc.springmvc.domain.LoginRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Log4j2
@Controller
@RequestMapping("/login") // 기본 경로 지정
public class LoginController {

    //@RequestMapping(method = RequestMethod.GET) // Servlet에서 메소드 호출한 것과 동일 효과
    @GetMapping
    public String getLoginForm(Model model){
        model.addAttribute("msg", "아이디와 패스워드를 반드시 입력하세요.");
        return "login/form"; // /WEB-INF/views/login/form.jsp
    }

    //@RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String login(
            String uid,
            String pw,
            String p,
            //@RequestParam(value = "p", required = true) String page
            @RequestParam(value = "p", defaultValue = "1") String page, // 입력되지 않으면 기본값
            HttpServletRequest request,
            HttpServletResponse response,
            @ModelAttribute("req") LoginRequest loginRequest, // Model에 만들어둔 객체가 파라미터 구별해줌
            @RequestParam Map paramMap
            ){



        String uid2 = request.getParameter("uid");
        String pw2 = request.getParameter("pw");

        log.info("uid =>" + uid);
        log.info("pw =>" + pw);
        log.info("p =>" + p);
        log.info("p =>" + page);
        log.info("uid2 =>" + uid2);
        log.info("pw2 =>" + pw2);
        log.info("loginRequest =>" + loginRequest);
        log.info("paramMap =>" + paramMap);


        request.getSession().setAttribute("loginInfo", uid);

        //return "login/login"; // "redirect:/index" <<sendRedirect 기능
        return "redirect:/mypage/mypage1";

    }



    // 기본 경로에 하위 경로 추가하기
    @GetMapping("/info")  // http://localhost:8080/login/info
    public String info(){
        return "login/info";
    }

}
