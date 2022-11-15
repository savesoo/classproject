package com.firstcoding.fisrtapp.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CookieDeleteServlet", value = "/cookie/delete")
public class CookieDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 쿠키 삭제 : 같은 이름의 쿠키 만들기
        Cookie cookie = new Cookie("userid", ""); // 삭제할 대상이라 공백 넣어도 ok
        // 쿠키 삭제 메소드는 없음 -> 유효시간을 0으로 적용해서 소멸시킴
        cookie.setMaxAge(0);

        response.addCookie(cookie);


        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/cookie/delete.jsp");
        dispatcher.forward(request, response);
    }

}
