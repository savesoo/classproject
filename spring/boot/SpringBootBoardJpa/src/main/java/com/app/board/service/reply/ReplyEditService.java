package com.app.board.service.reply;

import com.app.board.domain.ReplyDTO;
import com.app.board.entity.ReplyEntity;
import com.app.board.repository.ReplyRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Log4j2
@Service
public class ReplyEditService {
    @Autowired
    private ReplyRepository replyRepository;

    public int updateReplyByRno(ReplyDTO replyDTO){

        ReplyEntity replyEntity = replyDTO.toReplyEntity();
        replyEntity.setUpdateDate(LocalDate.now());
        replyEntity.setReplyDate(LocalDate.parse(replyDTO.getReplyDate()));

        return replyRepository.save(replyEntity) != null ? 1 : 0;
    }

}
