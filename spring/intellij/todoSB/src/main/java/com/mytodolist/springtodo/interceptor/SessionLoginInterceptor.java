package com.mytodolist.springtodo.interceptor;

import com.mytodolist.springtodo.domain.UserDTO;
import com.mytodolist.springtodo.service.UserLoginService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.UUID;

@Log4j2
public class SessionLoginInterceptor implements HandlerInterceptor {

    @Autowired(required = false)
    private UserLoginService service;

    //세션 체크하여 자동로그인 처리
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info(" >>> 세션 확인 후 자동 로그인 >>> ");

        // 쿠키에 저장된 uuid 여부 확인
        Cookie cookie = checkCookie(request.getCookies(), "uuid");
        log.info("cookie에 저장된 uuid = " + cookie.getValue());

        // 현 세션 체크 -> 쿠키 확인해서 자동로그인만 관리할 것
        HttpSession session = request.getSession(false);

        if(session==null || session.getAttribute("loginInfo")==null){

            log.info("세션 없음! 쿠키에서 찾아 처리 >>>> ");

            if(cookie!=null && cookie.getValue()!=null){ // 쿠키에 저장된 값(uuid)가 있으면

                // 로그인 처리
                UserDTO user = service.selectUUID(cookie.getValue()); // 저장된 uuid와 일치하는 user 정보 select
                log.info("user 정보 = " + user);

                // 해당하는 유저 정보가 있을 시 자동로그인 성공하고 uuid 갱신 처리
                if(user!=null){
                    UUID uuid = UUID.randomUUID();
                    service.updateUUID(uuid.toString(), user.getUser_idx());
                    user.setUuid(uuid.toString());
                    session.setAttribute("loginInfo", user.toLoginInfo()); // 세션에 uuid 저장

                    cookie.setValue(uuid.toString());
                    response.addCookie(cookie); // 갱신된 uuid 쿠키에 저장

                    log.info(" >>> rememberMe success >>> ");
                    return true;

                }

            }

            log.info("session = " + session);
            log.info(" >>> rememberMe fail >>> ");

            return true;

        }

        return true;

    }

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
