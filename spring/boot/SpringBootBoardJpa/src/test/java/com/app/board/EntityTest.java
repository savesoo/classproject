package com.app.board;

import com.app.board.entity.BoardEntity;
import com.app.board.entity.BoardRepository;
import com.app.board.entity.ReplyEntity;
import com.app.board.entity.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.hibernate.validator.constraints.Normalized;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
        List<ReplyEntity> list = replyRepository.findReplyEntitiesByBno(replyEntity.getBno());
        for (ReplyEntity entity : list){
            log.info(entity);
        }
    }
}
