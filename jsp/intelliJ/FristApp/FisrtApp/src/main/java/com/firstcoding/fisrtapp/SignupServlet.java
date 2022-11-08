package com.firstcoding.fisrtapp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SignupServlet", value = "/signup")
public class SignupServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String userid = request.getParameter("userid");
        String pw = request.getParameter("pw");
        String username = request.getParameter("username");

        response.setContentType("text/html;charset=UTF-8"); // 한글도 출력하기 위해 처리해줌

        PrintWriter out = response.getWriter();

        out.write("<html>");
        out.write("<head><meta charset=\"utf-8\"><title>회원 정보</title></head>");
        out.write("<body>");
        out.write("<h1> ID : " + userid + "</h1>");
        out.write("<h1> PW : " + pw + "</h1>");
        out.write("<h1> 회원 이름 : " + username + "</h1>");
        out.write("</body>");
        out.write("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 사용자 입력값 한글 처리
        request.setCharacterEncoding("UTF-8"); // post일 때는 getParameter 하기 전에 인코딩 필요

        // 파라미터 보낼 때는 name 생성 필요!
        String userid = request.getParameter("userid");
        String pw = request.getParameter("pw");
        String username = request.getParameter("username");

        String memo = request.getParameter("memo");
        String gender = request.getParameter("gender");
        //String lang = request.getParameter("lang"); // 첫 번째 값만 출력됨
        String[] langs = request.getParameterValues("lang"); // 선택한 걸 모두 출력

        String year = request.getParameter("year");


        response.setContentType("text/html;charset=UTF-8"); // 앞에서 인코딩 했어도 한번 더 해줘야 깨지지 않음

        PrintWriter out = response.getWriter();

        out.write("<html>");
        out.write("<head><meta charset=\"utf-8\"><title>회원 정보</title></head>");
        out.write("<body>");
        out.write("<h1> ID : " + userid + "</h1>");
        out.write("<h1> PW : " + pw + "</h1>");
        out.write("<h1> 회원 이름 : " + username + "</h1>");
        out.write("<h1> 소개글 : " + memo + "</h1>");
        out.write("<h1> 성별 : " + gender + "</h1>");

        System.out.println(langs);

        if(langs!=null) {
            for (String lang : langs) {
                out.write("<h1> 선택 언어 : " + lang + "</h1>");
            } // 모두 출력해야 하므로 for문 사용
        } else {

        }

        out.write("<h1> 선택 년도 : " + year + "</h1>");

        out.write("</body>");
        out.write("</html>");

    }
}
