package com.app.springsecurity.security;

import com.app.springsecurity.entity.Member;
import com.app.springsecurity.entity.MemberRole;
import com.app.springsecurity.repository.MemberRepository;
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
    private MemberRepository memberRepository;

    // 사용자 인증 처리 하고 있으면 DTO객체와 권한까지 반환
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 사용자 정보로 들어옴
        log.info(" >>>>>>>>>> loadUserByUsername >>>>> " + username);

        Optional<Member> result = memberRepository.findById(username);

        if(result.isEmpty()){
            throw new UsernameNotFoundException("Please Check User Email");
        }

        // 필요한 data
        Member member = result.get();

        log.info(" >>>>>>>>>> Member >>>>> " + member);

        // 권한은 컬렉션 타입의 GrantedAuthority 타입으로 반환해야 하므로
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        // memeber 안에 set 들어 있음 -> forEach로 반복
        for(MemberRole memberRole : member.getRoleSet()){
            // ROLE_ADMIN, ROLE_USER 형태로 저장되어야 함
            authorities.add(new SimpleGrantedAuthority("ROLE_" + memberRole.name()));
        }

        // 반환할 data
        AuthMemberDTO authMemberDTO = new AuthMemberDTO(
                member.getEmail(), member.getPassword(), authorities, member.getName()
        );

        return authMemberDTO;
    }

}
