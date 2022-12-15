package com.app.board.service;

import com.app.board.domain.BoardDTO;
import com.app.board.entity.BoardEntity;
import com.app.board.entity.BoardRepository;
import com.app.board.mapper.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.lang.reflect.Field;

@Log4j2
@Service
public class BoardDeleteService {

/*
    @Autowired
    private BoardMapper boardMapper;

    public int delete(int bno){

        // 삭제하려는 게시물의 Data(파일 여부 판단)
        BoardDTO boardDTO = boardMapper.selectByBno(bno);

        // 삭제 결과 확인
        int result = boardMapper.deleteByBno(bno);

        // 해당 게시물 DB에서 삭제 완료 + 게시물이 photo를 가지고 있음 -> 파일 삭제
        if(result>0 && boardDTO.getPhoto()!=null){

            File delFile = new File(new File("").getAbsolutePath(), "photo"+File.separator+boardDTO.getPhoto());
            if(delFile.exists()){
                delFile.delete();
            }
        }

        return result;
    }
*/


    @Autowired
    private BoardRepository boardRepository;

    public void delete(int bno){

        // 삭제하려는 게시물의 Data(파일 여부 판단)
        BoardEntity boardEntity = boardRepository.findByBno(bno);

        // 삭제 결과 확인
        boardRepository.deleteById(bno);

        if(boardEntity.getPhoto()!=null){
            File delFile = new File(new File("").getAbsolutePath(), "photo"+File.separator+boardEntity.getPhoto());
            if(delFile.exists()){
                delFile.delete();
            }
        }

    }

}
