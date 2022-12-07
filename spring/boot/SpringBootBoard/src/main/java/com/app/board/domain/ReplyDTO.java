package com.app.board.domain;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ReplyDTO {

    private int mo;
    private int bno;
    private String reply;
    private String replyer;
    private LocalDate replyDate;
    private LocalDate updateDate;

}
