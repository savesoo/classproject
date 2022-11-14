package todoController.todo;

import domain.TodoDTO;
import lombok.extern.log4j.Log4j2;
import service.TodoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@WebServlet(name = "TodoRegisterController", value = "/register")
public class TodoRegisterController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("Register doGet()");

        try{
            request.setAttribute("todoList",new TodoService().getAllList());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 등록 입력

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 등록 처리 -> Service 연결
        log.info("Register doPost()");

        TodoDTO todoDTO = new TodoDTO();

        request.setCharacterEncoding("utf-8");

        String todo = request.getParameter("todo");
        String dueDate = request.getParameter("dueDate");
        String finished = request.getParameter("finished");

        todoDTO.setTodo(todo);
        todoDTO.setDueDate(dueDate);
        todoDTO.setFinished(finished!=null ? true : false ); // checked = true, unchecked = false

        try {
            new TodoService().registToList(todoDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/list"); // DB 반영 후 list로 이동

    }
}
