package com.app.board.service;

import com.app.board.domain.ReplyDTO;
import com.app.board.entity.ReplyEntity;
import com.app.board.entity.ReplyRepository;
import com.app.board.mapper.ReplyMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ReplyInsertService {

    @Autowired
    private ReplyRepository replyRepository;

    public ReplyEntity insertReply(ReplyEntity replyEntity){
        return replyRepository.save(replyEntity);
    }

}


