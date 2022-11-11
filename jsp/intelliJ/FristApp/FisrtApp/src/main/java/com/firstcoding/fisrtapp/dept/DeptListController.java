package com.firstcoding.fisrtapp.dept;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeptListController", value = "/dept/list")
@Log4j2
public class DeptListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("Dept List get ...");

        DeptService service = new DeptService();

        //System.out.println("Dept List get ...");

        List<Dept> list = null;

        try {
            list = service.getList();
        } catch (Exception e) {
            //throw new RuntimeException(e); // 에러 표현이 아니라 그대로 null 넘기기
        }

        request.setAttribute("list", list);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/dept/list.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
