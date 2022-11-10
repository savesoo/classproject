package com.firstcoding.fisrtapp.calc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MakeResultController", value = "/calc/makeResult")
public class MakeResultController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");

        System.out.println(num1);
        System.out.println(num2);

        response.sendRedirect("/index.jsp");


    }
}
