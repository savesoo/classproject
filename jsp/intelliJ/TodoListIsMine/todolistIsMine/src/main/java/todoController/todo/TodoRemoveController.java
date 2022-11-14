package todoController.todo;

import lombok.extern.log4j.Log4j2;
import service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@WebServlet(name = "TodoRemoveController", value = "/remove")
public class TodoRemoveController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 삭제 처리
        log.info("remove Post()");

        String tno = request.getParameter("tno");

        try {
            new TodoService().removeTodo(Long.parseLong(tno));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/list"); // 삭제 끝나면 리스트로 이동

    }
}
