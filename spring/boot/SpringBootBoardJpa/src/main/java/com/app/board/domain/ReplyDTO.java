package com.app.board.domain;

import com.app.board.entity.BoardMemberEntity;
import com.app.board.entity.ReplyEntity;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ReplyDTO {

    private int rno;
    private int bno;
    private String reply;
    private Integer replyer; // String -> Integer

    private String replyDate;
    private String updateDate;


    public ReplyEntity toReplyEntity(){
        return ReplyEntity.builder()
                .rno(rno)
                .bno(bno)
                .reply(reply)
                .replyer(BoardMemberEntity.builder().idx(replyer).build())
                /*.replyDate(LocalDate.parse(replyDate))*/
                .build();
    }



}
