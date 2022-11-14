package todoController.user;

import domain.UserDTO;
import lombok.extern.log4j.Log4j2;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@WebServlet(name = "LoginController", value = "/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("login doGet()");

        UserDTO ud = new UserDTO();

        request.setCharacterEncoding("utf-8");

        String userID = request.getParameter("userID");
        String userPW = request.getParameter("userPW");

        ud.setUserID(userID);
        ud.setUserPW(userPW);

        try{
            request.setAttribute("user", new UserService().loginByIDPW(ud));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/user/login.jsp");
        dispatcher.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("Login doPost()");

        UserDTO ud = new UserDTO();

        request.setCharacterEncoding("utf-8");

        String userID = request.getParameter("userID");
        String userPW = request.getParameter("userPW");

        ud.setUserID(userID);
        ud.setUserPW(userPW);

        boolean isLogin = false;

        try {
            isLogin = new UserService().loginByIDPW(ud);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(isLogin){
            response.sendRedirect("/list");
        } else {
            response.sendRedirect("/login");
        }

    }
}
