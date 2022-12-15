package com.app.board.domain;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardArticleDTO {

    // join을 사용할 시에 새로운 DTO가 필요함!
    // select의 결과

    private int bno;
    private String title;
    private int replyCnt; // 댓글의 개수 추가
    private String content;
    private String writer;
    private String photo;
    private LocalDate regDate;
    private LocalDate updateDate;

}
