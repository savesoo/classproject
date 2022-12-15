package com.app.board.service;

import com.app.board.domain.BoardArticleDTO;
import com.app.board.domain.BoardListPage;
import com.app.board.entity.BoardEntity;
import com.app.board.entity.BoardRepository;
import com.app.board.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardListService {

    // jpa 적용

    @Autowired
    private BoardRepository boardRepository;

    public BoardListPage getPage(int pageNum){

        Pageable pageable = PageRequest.of(pageNum-1, 10, Sort.by("bno").descending());
        Page<BoardEntity> list = boardRepository.findAll(pageable);

        BoardListPage boardListPage = new BoardListPage(10, pageNum, list.getContent(), list.getTotalElements());
        return boardListPage;

    }




}
