package com.firstcoding.fisrtapp.cookie;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.UUID;

@Log4j2
@WebServlet(name = "CookieCreateServlet", value = "/cookie/create")
public class CookieCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 쿠키 생성
        Cookie cookie = new Cookie("userid", "sweet");
        cookie.setMaxAge(60*10);
        response.addCookie(cookie);

        // 유니크한 식별값
        UUID str = UUID.randomUUID();
        log.info("유니크한 식별값 생성 -> " + str.toString());

        Cookie c = new Cookie("uuid", str.toString()); // 쿠키 생성 -> 문자열로 저장
        c.setMaxAge(60*60*24*7); // 초*분*시간*날짜
        response.addCookie(c);

        c.setHttpOnly(true); // JavaScript에서 접속이 불가!!

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cookie/create.jsp");
        dispatcher.forward(request, response);

    }

}
