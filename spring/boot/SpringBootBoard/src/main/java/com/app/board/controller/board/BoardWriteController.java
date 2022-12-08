package com.app.board.controller.board;

import com.app.board.domain.BoardWriteRequest;
import com.app.board.service.BoardWriteService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Log4j2
@Controller
@RequestMapping("/board/write")
public class BoardWriteController {


    @Autowired
    private BoardWriteService boardWriteService;

    @GetMapping
    public void writeForm(){
    }


    @PostMapping
    public String write(BoardWriteRequest boardWriteRequest){

        log.info( "port write >>>>>>>>>>> " + boardWriteRequest);

        // file 클래스에서 특정 경로의 절대 경로 가져오기
        // 위치에 있는 자원을 찾아서 inputStream 해주기
        String absolutePath = new File("").getAbsolutePath();
        log.info( " >>>>>>>>>>>>> path : " + absolutePath);

        boardWriteService.write(boardWriteRequest);

        return "redirect:/board/list";
    }


}
