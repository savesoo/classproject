package com.firstcoding.fisrtapp.login;

import com.firstcoding.fisrtapp.login.domain.Member;
import com.firstcoding.fisrtapp.login.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.UUID;

@Log4j2
@WebServlet(name = "LoginController", value = "/logins")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("Login Form page ... ");

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/login/loginform.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userid = request.getParameter("userid");
        String pw = request.getParameter("pw");
        String idremember = request.getParameter("idremember");
        String rememberMe = request.getParameter("rememberMe");

        log.info("userID : " + userid);
        log.info("pw : " + pw);
        log.info("idremember : " + idremember);
        log.info("rememberMe : " + rememberMe);

        // idremember null이 아니면 userid를 쿠키에 저장
        if(idremember!=null){
            // 쿠키 생성
            Cookie c = new Cookie("remId", userid);
            c.setMaxAge(60*60*24*180); // 6개월
            response.addCookie(c);
        } else {
            // 동일명의 쿠키 삭제 처리
            Cookie c = new Cookie("remId", userid);
            c.setMaxAge(0);
            response.addCookie(c);
        }




        HttpSession session = request.getSession();

        // 로그인 처리
        // id, pw 비교 -> db에 저장된 회원 정보에서 id, pw 일치 여부 확인
        try {
            Member member = MemberService.getInstance().login(userid, pw);

            if(member==null){
                response.sendRedirect("/logins?error=nf");
                return;
            }

            // rememberMe 값이 on이면 -> 회원 DB -> uuid 업데이트!

            log.info(member);

            if(rememberMe!=null && rememberMe.equals("on")){


                // Cookie 저장, DB Update
                UUID uuid = UUID.randomUUID();
                Cookie c = new Cookie("uuid", uuid.toString());
                c.setMaxAge(60*60*24*30);
                c.setPath("/");
                response.addCookie(c);

                // 로그인한 사용자의 uuid를 DB로 upadate
                MemberService.getInstance().updateUUID(member.getIdx(), uuid.toString());

            }

            // 아이디와 비번이 일치하는 회원 존재 -> 로그인 처리
            session.setAttribute("loginInfo", member.getUid());
            response.sendRedirect("/index.jsp");

        } catch (Exception e) {
            log.error(e.getStackTrace());
            response.sendRedirect("/logins?error=e");
        }


        // id pw 문자열이 같으면 로그인 처리 -> session 속성에 회원의 정보를 저장
 /*       if(userid.equals(pw)) {
            session.setAttribute("loginInfo", "로그인 완료");
            response.sendRedirect("/index.jsp");
        } else {
            response.sendRedirect("/logins");
        }
 */


    }
}
