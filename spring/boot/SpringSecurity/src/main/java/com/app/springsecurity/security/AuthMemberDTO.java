package com.app.springsecurity.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class AuthMemberDTO extends User {

    // 사용자 정보에 추가로 가지고 들어갈 수 있도록
    private String name;

    // 로그인 할 때 이 깂을 가지고 인증
    public AuthMemberDTO(String username,
                         String password,
                         Collection<? extends GrantedAuthority> authorities,
                         String name) {
        super(username, password, authorities);
        this.name = name;
    }
}
