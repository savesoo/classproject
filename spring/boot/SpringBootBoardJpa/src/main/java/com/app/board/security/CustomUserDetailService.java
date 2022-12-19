package com.app.board.security;

import com.app.board.entity.BoardMemberEntity;
import com.app.board.repository.BoardMemberRepository;
import com.app.board.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private BoardMemberRepository boardMemberRepository; // mybaits로 한다면 mapper


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info( ">>>>> loadUserByUsername >>>>>" + username);

        Optional<BoardMemberEntity> result = boardMemberRepository.findByUserid(username);

        // 예외 처리
        if(result.isEmpty()){
            throw new UsernameNotFoundException("회원의 ID 혹은 비밀번호를 확인해주세요.");
        }

        // 회원의 정보, 권한 정보 -> CustomUser 인스턴스 생성 및 반환
        BoardMemberEntity boardMember = result.get();

        log.info( ">>>>> 회원 정보 >>>>>" + boardMember);

        // 권한 데이터 처리
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + boardMember.getRole()));

        CustomUser user = new CustomUser(
                boardMember.getUserid(),
                boardMember.getPassword(),
                authorities,
                boardMember );

        return user;
    }
}
