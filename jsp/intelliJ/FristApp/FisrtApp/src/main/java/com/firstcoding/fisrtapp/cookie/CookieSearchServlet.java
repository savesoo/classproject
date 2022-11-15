package com.firstcoding.fisrtapp.cookie;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "CookieSearchServlet", value = "/cookie/search")
public class CookieSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cookieName = request.getParameter("cname");

        String value = ""; // 찾으려는 값 검색

        Cookie[] cookies = request.getCookies();

        // data 처리~ 보통 별도 메소드로 만들어 사용함
        for (int i=0; i<cookies.length; i++){
            Cookie c = cookies[i];
            if(cookieName.equals(c.getName())){
                value = c.getValue();
                break;
            }
        }

        request.setAttribute("result", value);

        // search 결과 페이지로 전송
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cookie/search.jsp");
        dispatcher.forward(request, response);

    }

}
