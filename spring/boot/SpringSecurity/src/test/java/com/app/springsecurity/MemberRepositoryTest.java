package com.app.springsecurity;

import com.app.springsecurity.entity.Member;
import com.app.springsecurity.entity.MemberRole;
import com.app.springsecurity.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;

@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder; // 암호화 필요하므로 주입

    @Test
    public void insertMemberTest(){

        Member member = Member.builder()
                .email("test1@gmail.com")
                .name("사용자-1")
                .roleSet(new HashSet<MemberRole>()) // 저장할 때 넣어주기 위해
                .password(passwordEncoder.encode("1111"))
                .build();

        // 기본 권한 부여
        member.addMemberRole(MemberRole.ADMIN);

        memberRepository.save(member);

    }
}
