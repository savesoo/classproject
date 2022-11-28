package com.mytodolist.springtodo.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j2
public class SessionLoginInterceptor implements HandlerInterceptor {

    @Autowired
//    private UserService service;

    // 세션 체크하여 자동로그인 처리
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        log.info(" >>> 세션 확인 후 자동 로그인 >>> ");
//
//        // 쿠키에 저장된 uuid 여부 확인
//        Cookie cookie = checkCookie(request.getCookies(), "uuid");
//        // 현 세션 체크 -> 세션이 없으면 null값 반환
//        HttpSession session = request.getSession(false);
//
//        if(session==null || session.getAttribute("loginInfo")!=null){
//
//            log.info(" >>> rememberMe fail >>> ");
//            return true;
//
//        }
//
//        if(cookie!=null){
//
//            String uuid = cookie.getValue();
//
//            // 로그인 처리
//            UserDTO user = service.selectUUID(uuid);
//            log.info(" >>> rememberMe success >>> ");
//            session.setAttribute("loginInfo", user.getUserID());
//
//        }
//
//        return true;
//    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    private Cookie checkCookie(Cookie[] cookies, String cname){

        // 쿠키 없으면 null
        if(cookies==null && cookies.length==0){
            return null;
        }

        Cookie cookie = null;

        // 배열 안에서 같은 이름의 쿠키 발견하면 반환
        for(int i=0; i< cookies.length; i++){
            if(cname.equals(cookies[i].getName())){
                cookie = cookies[i];
                break;
            }
        }

        return cookie;
    }

}
