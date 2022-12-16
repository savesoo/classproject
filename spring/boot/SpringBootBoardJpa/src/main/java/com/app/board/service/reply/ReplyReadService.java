package com.app.board.service.reply;

import com.app.board.entity.ReplyEntity;
import com.app.board.repository.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ReplyReadService {

    @Autowired
    private ReplyRepository replyRepository;
    public ReplyEntity selectReplyByRno(int rno){

        return replyRepository.findById(rno).get();
    }



}
