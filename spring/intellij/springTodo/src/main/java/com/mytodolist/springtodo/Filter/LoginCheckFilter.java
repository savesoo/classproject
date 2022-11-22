package com.mytodolist.springtodo.Filter;

import com.mytodolist.springtodo.domain.UserDTO;
import com.mytodolist.springtodo.service.UserService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebFilter(filterName = "LoginCheckFilter", urlPatterns = {"/todo/*"})
public class LoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    // Filter가 먼저, Spring 진입 후 Interceptor가 나중에 동작
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        log.info(" >>> 로그인 체크 필터 진입 >>> ");

        // ServletRequest가 더 상위이므로 형변환
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        if(session.getAttribute("loginInfo")==null){

            //UserDTO user = UserService.ud.selectByIDPW();
            //session.setAttribute("loginInfo", );

        }

            chain.doFilter(request, response);

    }


}
