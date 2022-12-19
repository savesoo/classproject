package com.app.board.security;

import com.app.board.entity.BoardMemberEntity;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class CustomUser extends User {

    // 세션의 개념과 비슷함!
    @Autowired
    private BoardMemberEntity boardMember;  // 추가적인 회원의 정보(객체로 넣어줌)

    public CustomUser(String username,
                      String password,
                      Collection<? extends GrantedAuthority> authorities,
                      BoardMemberEntity boardMember) {
        super(username, password, authorities);
        this.boardMember = boardMember;
    }

    public CustomUser(String username,
                      String password,
                      boolean enabled,
                      boolean accountNonExpired,
                      boolean credentialsNonExpired,
                      boolean accountNonLocked,
                      Collection<? extends GrantedAuthority> authorities,
                      BoardMemberEntity boardMember) {
        super(username, password, enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, authorities);
        this.boardMember = boardMember;
    }

    @Override
    public String toString() {
        return "CustomUser{" +
                "boardMember=" + boardMember +
                '}';
    }

}
