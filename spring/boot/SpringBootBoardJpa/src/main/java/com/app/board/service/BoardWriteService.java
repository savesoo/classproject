package com.app.board.service;

import com.app.board.domain.BoardDTO;
import com.app.board.domain.BoardWriteRequest;
import com.app.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.UUID;

@Log4j2
@Service
public class BoardWriteService {

    @Autowired
    private BoardMapper boardMapper;

    public int write(BoardWriteRequest boardWriteRequest){

        MultipartFile file = boardWriteRequest.getFormFile();

        File saveDir = null;
        String newFileName = null;

        if(file != null && !file.isEmpty() && file.getSize()>0){

            String absolutePath = new File("").getAbsolutePath();
            log.info(absolutePath);

            String path = "photo";
            saveDir = new File(absolutePath, path); // photo를 포함한 새 경로

            // 폴더가 존재하지 않으면 생성
            if(!saveDir.exists()){
                saveDir.mkdir(); // make directory
                log.info(" >>>>>> photo 디렉토리 생성! ");
            }

            // 난수 입력 발생 ->
            String uuid = UUID.randomUUID().toString();
            // 게시물에 종속시키기 위해 이름 따로 저장 : 새 파일의 이름을 생성
            newFileName = uuid+file.getOriginalFilename();

            // 새로운 저장 파일의 경로(생성한 폴더에 저장됨)
            File newFile = new File(saveDir, newFileName);

            try {
                // 파일 저장
                file.transferTo(newFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        BoardDTO boardDTO = boardWriteRequest.toBoardDTO();

        if(newFileName != null){
            boardDTO.setPhoto(newFileName);
        }

        int result = 0;

        try {
            // DB insert
            result = boardMapper.insert(boardDTO);
        } catch (SQLException e){

            // 만약 파일 이름이 없다면 삭제 처리
            if(newFileName!=null){
                File delFile = new File(saveDir, newFileName);
                if(delFile.exists()){
                    // 파일 삭제
                    delFile.delete();
                }
            }

            e.printStackTrace();
        }

        return result;

    }
}
