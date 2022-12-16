package com.app.board.service.reply;

import com.app.board.domain.ReplyDTO;
import com.app.board.entity.BoardEntity;
import com.app.board.entity.ReplyEntity;
import com.app.board.repository.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Log4j2
@Service
public class ReplyInsertService {

    @Autowired
    private ReplyRepository replyRepository;

    public ReplyEntity insertReply(ReplyDTO replyDTO){

        // 사용자에게 ReplyDTO로 입력받아서 Entity랑 연결해줄 것이므로!!!
        ReplyEntity reply = replyDTO.toReplyEntity();
        reply.setReplyDate(LocalDate.now());
        reply.setUpdateDate(LocalDate.now());

        return replyRepository.save(reply);
    }

}


