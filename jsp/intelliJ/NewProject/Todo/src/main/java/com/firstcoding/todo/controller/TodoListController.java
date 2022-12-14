package com.firstcoding.todo.controller;

import com.firstcoding.todo.service.TodoService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TodoListController", value = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("todo list ...");

        // 출력 결과
        //String title = "TODO LIST";
        request.setAttribute("title", "Todo List");
        request.setAttribute("todoList", new TodoService().getTodoList());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todotodo/list.jsp");
        dispatcher.forward(request, response);

    }


}
