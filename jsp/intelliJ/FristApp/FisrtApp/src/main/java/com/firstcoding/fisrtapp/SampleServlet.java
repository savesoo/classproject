package com.firstcoding.fisrtapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SampleServlet", value = "/sample")
public class SampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>>>>> doGet() 실행");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(">>>>>>>>>>>>>> doPost() 실행");
    }

    @Override
    public void destroy() {
        System.out.println(">>>>>>>>>>>>>> destroy() 실행");
    }

    @Override
    public void init() throws ServletException {
        System.out.println(">>>>>>>>>>>>>> init() 실행");
    }

}
