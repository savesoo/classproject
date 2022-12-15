package com.app.board.service;

import com.app.board.domain.ReplyDTO;
import com.app.board.entity.ReplyEntity;
import com.app.board.entity.ReplyRepository;
import com.app.board.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyListService {

    @Autowired
    private ReplyRepository replyRepository;

    public List<ReplyEntity> selectAll(int bno){
        return replyRepository.findReplyEntitiesByBno(bno);
    }


}
