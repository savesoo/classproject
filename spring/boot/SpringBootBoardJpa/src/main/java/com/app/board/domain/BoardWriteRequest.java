package com.app.board.domain;

import com.app.board.entity.BoardEntity;
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
    private String writer;
    private String content;
    private MultipartFile formFile;

    public BoardDTO toBoardDTO(){
        return BoardDTO.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }

    public BoardEntity toBoardEntity(){
        return BoardEntity.builder()
                .title(title)
                .content(content)
                .writer(writer)
                .build();
    }

}
