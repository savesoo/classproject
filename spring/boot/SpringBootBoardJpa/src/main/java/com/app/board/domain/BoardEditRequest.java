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
public class BoardEditRequest {

    private int bno;
    private int currentPageNum;
    private String title;
    private Integer writer; // String -> Integer
    private String content;
    private String oldFile;
    private MultipartFile formFile;


/*    public BoardDTO toBoardDTO(){
        return BoardDTO.builder()
                .bno(bno)
                .writer(writer)
                .title(title)
                .content(content)
                .photo(oldFile)
                .build();
    }*/

    public BoardEntity toBoardEntity(){
        return BoardEntity.builder()
                .bno(bno)
                .writer(BoardMemberEntity.builder().idx(writer).build())
                .title(title)
                .content(content)
                .photo(oldFile)
                .build();
    }

}
