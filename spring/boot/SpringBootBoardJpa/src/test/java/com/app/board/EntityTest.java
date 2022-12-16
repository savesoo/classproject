package com.app.board;

import com.app.board.domain.BoardEditRequest;
import com.app.board.domain.BoardWriteRequest;
import com.app.board.entity.BoardEntity;
import com.app.board.repository.BoardRepository;
import com.app.board.entity.ReplyEntity;
import com.app.board.repository.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Log4j2
public class EntityTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void boardEntityTest(){


        List<BoardEntity> list = boardRepository.findAll();
        for (BoardEntity board : list){
            log.info(board);
        }





    }


    @Test
    public void replyEntityTest(){

        ReplyEntity replyEntity = ReplyEntity.builder().bno(119).build();
        List<ReplyEntity> list = replyRepository.findByBno(replyEntity.getBno());
        for (ReplyEntity entity : list){
            log.info(entity);
        }
    }


    ////////////////


    @Test
    public void saveTest(){

        /*
        BoardWriteRequest -> Entity -> save()
        */

        BoardWriteRequest writeRequest = BoardWriteRequest.builder()
                        .title("2022-12-16 JPA test write")
                        .writer("JPA")
                        .content("test run!")
                        .build();

        BoardEntity board = writeRequest.toBoardEntity();

        log.info(" insert 전 : " + board);
        log.info(" insert 후 : " + boardRepository.save(board));

    }

    @Test
    public void findByIdTest(){

        // view 페이지, edit form
        Optional<BoardEntity> result = boardRepository.findById(119);

        BoardEntity board = result.get(); // notnull일 때 클래스 타입으로 반환

        log.info(" 119번 게시물 >>> " + board);
    }

    @Test
    public void editTest(){

        // form에서 가져오는 데이터
        BoardEditRequest editRequest = BoardEditRequest.builder()
                .bno(119)
                .title("December 16th updated by JD")
                .content("this baord is updated")
                .build();

        // request -> Entity
        BoardEntity board = editRequest.toBoardEntity();
        board.setUpdateDate(LocalDate.now());

        log.info(" update 전 : " + board);

        BoardEntity editBoard = boardRepository.save(board);

        log.info(" update 후 : " + editBoard);

    }

    @Test
    public void dleteTest(){

        int result = boardRepository.deleteByBno(130);
        log.info(" delete 결과 >>>>> " + result);

    }

    @Test
    public void listTest(){

        // 페이징 -> 구간 select, 한 페이지에 10개의 게시물 출력
        Page<BoardEntity> page = boardRepository.findAll(PageRequest.of(0, 10, Sort.by("bno").descending()));

        // 전체 페이지 개수
        long totalCnt = page.getTotalElements();
        log.info(" 전체 게시물의 개수 >>>>>>> " + totalCnt);
        // 게시물 리스트
        for( BoardEntity board : page.getContent()){
            log.info(board);
        }
    }

}
