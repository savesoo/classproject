package com.firstcoding.fisrtapp.mypage;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "MypageController", value = "/mypage/mypage")
public class MypageController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("Mypage .....");

        // 현재 로그인 중인지 확인
//        HttpSession session = request.getSession();

        // 세션이 없음
//        if(session.isNew()) {
//            log.info("비로그인 상태 .... ");
//            response.sendRedirect("/logins");
//            return;
//        }

//        // 세션은 있으나 로그인 안함
//        if(session.getAttribute("loginInfo") == null) {
//            log.info("비로그인 상태 .... ");
//            response.sendRedirect("/logins");
//            return;
//        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/mypage/mypage.jsp");
        dispatcher.forward(request, response);

    }

}
