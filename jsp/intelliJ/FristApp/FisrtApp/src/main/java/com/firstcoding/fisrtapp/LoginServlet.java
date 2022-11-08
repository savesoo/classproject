package com.firstcoding.fisrtapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 사용자가 입력한 데이터를 추출
        String userid = request.getParameter("userid"); // 파라미터 이름에 따라 가져옴
        String pw = request.getParameter("pw");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.write("<html>");
        out.write("<head><title>로그인 데이터</title></head>");
        out.write("<body>");
        out.write("<h1> userid : " + userid + "<h1>");
        out.write("<h1> pw : " + pw + "<h1>");
        out.write("</body>");
        out.write("</html>");
    }


}
