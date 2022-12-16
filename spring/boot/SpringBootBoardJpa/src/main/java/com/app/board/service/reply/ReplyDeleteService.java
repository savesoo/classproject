package com.app.board.service.reply;

import com.app.board.repository.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ReplyDeleteService {

    @Autowired
    private ReplyRepository replyRepository;

/*    public void deleteReplyByRno(int rno){
        replyRepository.deleteById(rno);
    }*/

    public int deleteReplyByRno(int rno){
        return replyRepository.deleteByRno(rno);
    }

}
