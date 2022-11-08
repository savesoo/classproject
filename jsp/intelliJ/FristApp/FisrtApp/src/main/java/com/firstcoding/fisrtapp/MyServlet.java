package com.firstcoding.fisrtapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="myServlet", urlPatterns = "/my" ) // 하나는 "" , 여러 개는 {} 사용
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        //resp.setStatus(500); // 서버 오류

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>MyServlet</title>");
        out.println("</html>");
        out.println("<body>");
        out.println("<h1>MyServlet</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}
