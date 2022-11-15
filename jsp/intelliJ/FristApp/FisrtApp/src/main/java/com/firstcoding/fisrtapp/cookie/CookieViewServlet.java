package com.firstcoding.fisrtapp.cookie;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "CookieViewServlet", value = "/cookie/view")
public class CookieViewServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Cookie 확인
        Cookie[] cookies = request.getCookies();

        // 찾고 싶은 cookie의 key를 알면 반복문으로 찾을 수 있음!
        for ( Cookie c : cookies ) {
            log.info(c.getName() + " = " + c.getValue());
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cookie/view.jsp");
        dispatcher.forward(request, response);
    }

}
