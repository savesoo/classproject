package com.app.board.service;

import com.app.board.domain.ReplyDTO;
import com.app.board.mapper.ReplyMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ReplyEditService {

    @Autowired
    private ReplyMapper replyMapper;

    public int updateReplyByRno(ReplyDTO replyDTO){
        return replyMapper.updateReplyByRno(replyDTO);
    }

}
