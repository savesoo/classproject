package com.app.board.domain;

import com.app.board.entity.BoardEntity;
import com.app.board.entity.BoardMemberEntity;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BoardWriteRequest {

    private String title;

    // 작성자 이름 문자열 -> 작성자의 idx
    /*private String writer;*/
    private Integer writer;

    private String content;
    private MultipartFile formFile;

/*    public BoardDTO toBoardDTO(){
        return BoardDTO.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }*/

    public BoardEntity toBoardEntity(){
        return BoardEntity.builder()
                .title(title)
                .content(content)
                .writer(BoardMemberEntity.builder().idx(writer).build())
                .build();
    }

}
