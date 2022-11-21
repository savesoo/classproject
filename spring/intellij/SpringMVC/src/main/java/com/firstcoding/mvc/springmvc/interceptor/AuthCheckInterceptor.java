package com.firstcoding.mvc.springmvc.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Log4j2
public class AuthCheckInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        log.info(" >>>>>>>>>>> 회원 로그인 여부 체크 >>>>>>>>> ");


        // 회원 로그인 상태 체크
        HttpSession session = request.getSession(false); // 현재 세션이 없을 수도 = null처리

        // 회원이 로그인 상태일 때
        if(session != null && session.getAttribute("loginInfo") != null){
            // 로그인 상태 = 세션이 있고 loginInfo 속성이 있어야 함
            log.info(" >>>>>>> 로그인 유지 상태 >>>>>>> ");
            return true; // 다음 인터셉터로 넘어감
        }

        log.info(" >>>>>>> 비 로그인 상태 >>>>>>> ");
        response.sendRedirect("/login");
        return false; // 다음 단계로 넘어가지 못함

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
