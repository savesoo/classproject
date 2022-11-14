package todoController.todo;

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
@WebServlet(name = "TodoListController", value = "/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 목록 -> 조회
        log.info("list doGet()");

        try {
            request.setAttribute("todoList", new TodoService().getAllList());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/list.jsp");
        dispatcher.forward(request, response);

    }

 //   @Override
 //   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    }

}
