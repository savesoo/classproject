package com.app.board.service.reply;

import com.app.board.entity.ReplyEntity;
import com.app.board.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReplyListService {

    @Autowired
    private ReplyRepository replyRepository;

    public List<ReplyEntity> selectAll(int bno){
        return replyRepository.findByBno(bno);
    }


}
