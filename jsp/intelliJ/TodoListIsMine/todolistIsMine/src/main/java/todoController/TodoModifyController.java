package todoController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TodoModifyController", value = "/modify")
public class TodoModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 수정 입력
        System.out.println("Modify doGet()");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/todo/modify.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 수정 처리
        System.out.println("Modify doPost()");

        response.sendRedirect("/list");

    }
}
