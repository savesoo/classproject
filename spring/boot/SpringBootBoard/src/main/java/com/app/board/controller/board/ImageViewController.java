package com.app.board.controller.board;

import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;

@Log4j2
@Controller
public class ImageViewController {

    // DB에 넣은 파일을 '이미지'로 인식시켜 사용자 화면에서도 출력하기 위한 컨트롤러
    // 요청하는 파일만 있으면 응답처리 가능해짐

    @GetMapping(value = "/upload/photo/{fileName}", produces = MediaType.IMAGE_PNG_VALUE) // 응답처리
    @ResponseBody
    public ResponseEntity<byte[]> viewImage(@PathVariable("fileName") String fileName) throws IOException {

        log.info( " >>> ImageView Controller >>> " + fileName);

        byte[] imageByteArray = null;
        HttpStatus status = HttpStatus.NOT_FOUND;

        // 저장된 파일의 경로
        File savedFile = new File(new File("").getAbsolutePath(), "photo"+File.separator+fileName);

        if(savedFile.exists()){
            // 저장된 파일이 존재할 때 응답 처리(응답코드)
            InputStream imageStream = new FileInputStream(savedFile);
            imageByteArray = imageStream.readAllBytes();
            imageStream.close();

            status = HttpStatus.OK;
        }

        log.info("savedFile >>> " + savedFile);

        return new ResponseEntity<byte[]>(imageByteArray, status);
    }
}
