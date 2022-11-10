package com.firstcoding.fisrtapp.calc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "InputController", value = "/calc/input") // .jsp 안붙임(서블릿이 아닌 jsp로 이동)
public class InputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("calc InputController : doGet()"); // 정상 접근 확인용

        // Controller(Servlet이 처리) -> Model (Service -> Dao)
        // Model -> Controller : 데이터 반환

        // 결과 데이터
        String result = "계산기"; // Model을 통한 결과 Data

        // view 페이지에 결과 데이터 전달(공유)
        request.setAttribute("title", result);

        // 응답으로 처리할 view 지정
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/calc/input.jsp");
        // forward : request 객체 공유!!!
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 사용자가 입력한 데이터 받기
        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");


        // 핵심 처리
        int result = Integer.parseInt(num1) + Integer.parseInt(num2);

        req.setAttribute("num1", num1);
        req.setAttribute("num2", num2);
        req.setAttribute("result", result);


        // 결과 view 생성 및 처리
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/calc/result.jsp");
        dispatcher.forward(req, resp);

    }
}
