package todoController.user;

import dao.UserDao;
import domain.UserDTO;
import lombok.extern.log4j.Log4j2;
import service.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@Log4j2
@WebServlet(name = "SignUpController", value = "/signup")
public class SignUpController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 사용자에게서 입력받을 view 출력
        log.info("SignUp doGet()");

        UserDTO ud = new UserDTO();

        request.setCharacterEncoding("utf-8");

        String userID = request.getParameter("userID");
        String userPW = request.getParameter("userPW");
        String checkPW = request.getParameter("checkPW");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/signup.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Service와 연결

        UserDTO ud = new UserDTO();

        request.setCharacterEncoding("utf-8");

        String userID = request.getParameter("userID");
        String userPW = request.getParameter("userPW");
        String checkPW = request.getParameter("checkPW");
        String userName = request.getParameter("userName");

        ud.setUserID(userID);
        ud.setUserPW(userPW);
        ud.setUserName(userName);

        if(userPW.equals(checkPW)) {
            response.sendRedirect("/login");
        } else {
            response.sendRedirect("/signup");
        }
    }
}
