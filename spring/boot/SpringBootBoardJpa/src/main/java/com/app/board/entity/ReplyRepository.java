package com.app.board.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {

    List<ReplyEntity> findReplyEntitiesByBno(Integer bno);
}
