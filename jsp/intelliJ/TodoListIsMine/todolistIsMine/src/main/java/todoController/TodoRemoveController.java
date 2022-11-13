package todoController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
