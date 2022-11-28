package com.mytodolist.springtodo.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
public class AuthCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 세션 확인하여 로그인 정보 없으면 false 처리
        HttpSession session = request.getSession(false);

        // 회원 로그인 여부 체크 = session 혹은 longinInfo 유무
        if(session!=null && session.getAttribute("loginInfo")!=null){

            log.info(" >>>> 로그인 유지 상태 >>>> ");
            return true;
        }

        log.info(" >>>> 비로그인 상태 >>>> ");
        response.sendRedirect("/user/login");
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
