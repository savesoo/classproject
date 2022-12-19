package com.app.board;

import com.app.board.entity.BoardMemberEntity;
import com.app.board.repository.BoardMemberRepository;
import com.app.board.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@Log4j2
@SpringBootTest
public class BoardMemberRepositoryTest {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private BoardMemberRepository boardMemberRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Test
    public void saveTest(){

        BoardMemberEntity boardMember = BoardMemberEntity.builder()
                .userid("hot")
                .password(encoder.encode("1111"))
                .username("문")
                .role("USER")
                .regdate(LocalDate.now())
                .editdate(LocalDate.now())
                .build();

        BoardMemberEntity member = boardMemberRepository.save(boardMember);

        log.info(member);



    }
}
