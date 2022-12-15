package com.app.board.service;

import com.app.board.domain.BoardDTO;
import com.app.board.entity.BoardEntity;
import com.app.board.entity.BoardRepository;
import com.app.board.mapper.BoardMapper;
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
        return boardRepository.findByBno(bno);
    }

}
