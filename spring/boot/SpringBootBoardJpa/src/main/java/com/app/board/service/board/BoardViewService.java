package com.app.board.service.board;

import com.app.board.entity.BoardEntity;
import com.app.board.repository.BoardRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class BoardViewService {

   /* @Autowired
    private BoardMapper boardMapper;

    public BoardDTO selectBoardDTO(int bno){
        return boardMapper.selectByBno(bno);
    }*/

    @Autowired
    private BoardRepository boardRepository;

    public BoardEntity selectBoardEntity(int bno){
        return boardRepository.findById(bno).get(); // notnull일 때 체크하기 위한 .get()
    }

}
