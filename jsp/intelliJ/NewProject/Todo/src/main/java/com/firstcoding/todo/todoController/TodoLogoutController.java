package com.firstcoding.todo.todoController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TodoLogoutController", value = "/logout")
public class TodoLogoutController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("logout doGet()");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/logout.jsp");
        dispatcher.forward(request, response);
        
    }

}
