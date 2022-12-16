package com.app.springsecurity.security;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {

        log.info(" SuccessHandler ........................ ");

        // 인증정보 받을 때
        AuthMemberDTO authMemberDTO = (AuthMemberDTO) authentication.getPrincipal();

        String pw = request.getParameter("password");

        log.info( " >>>>>>>>>> pw >>>>> " + pw);

        boolean passResult = passwordEncoder.matches(pw, authMemberDTO.getPassword()); // 원래 pw, 암호화된 pw

        if(passResult){
            response.sendRedirect("/sample/login?error");
        }

        log.info(authMemberDTO.getAuthorities());

        // ROLE_ADMIN, ROLE_USER 값이 들어 있는 list
        List<String> roleNames = new ArrayList<>();

        for(GrantedAuthority authority : authMemberDTO.getAuthorities()){
            // 권한의 이름을 String 리스트에 저장
            roleNames.add(authority.getAuthority());
        }

        // 분기 처리
        if(roleNames.contains("ROLE_ADMIN")){
            response.sendRedirect("/sample/admin");
        } else if(roleNames.contains("ROLE_USER")){
            response.sendRedirect("/sample/member");
        }

    }
}
