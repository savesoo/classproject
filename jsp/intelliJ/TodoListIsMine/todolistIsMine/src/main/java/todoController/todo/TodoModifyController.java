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
@WebServlet(name = "TodoModifyController", value = "/modify")
public class TodoModifyController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 사용자가 입력한 데이터 추출
        // 수정 입력
        log.info("Modify doGet()");

        String tno = request.getParameter("tno");

        try {
            request.setAttribute("todo",new TodoService().getTodoByTno(Long.parseLong(tno)));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 보여줄 view 페이지
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/modify.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 수정 처리
        // Service와 연결
        log.info("Modify doPost()");

        request.setCharacterEncoding("utf-8");

        String tno = request.getParameter("tno");
        String todo = request.getParameter("todo");
        String dueDate = request.getParameter("dueDate");
        String finished = request.getParameter("finished");

        TodoDTO todoDTO = new TodoDTO(Long.parseLong(tno), todo, dueDate, finished!=null ? true : false);

        try {
            new TodoService().updateTodo(todoDTO);
        } catch (SQLException e) {
            //throw new RuntimeException(e);
        }

        response.sendRedirect("/list");

    }
}
