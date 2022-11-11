package com.firstcoding.todo.todoController;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoRemoveController", value = "/remove")
public class TodoRemoveController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 삭제 처리
        System.out.println("remove Post()");

        response.sendRedirect("/list"); // 삭제 끝나면 리스트로 이동

    }
}
