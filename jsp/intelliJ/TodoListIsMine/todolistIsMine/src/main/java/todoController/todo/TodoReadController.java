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
@WebServlet(name = "TodoReadController", value = "/read")
public class TodoReadController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 데이터 조회 - view 연결

        log.info("read doGet()");

        String tno = request.getParameter("tno");

        try {
            request.setAttribute("todo",new TodoService().getTodoByTno(Long.parseLong(tno)));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/read.jsp");
        dispatcher.forward(request, response);
    }

}
