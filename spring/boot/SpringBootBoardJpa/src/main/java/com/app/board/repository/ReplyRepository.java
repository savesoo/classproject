package com.app.board.repository;

import com.app.board.entity.ReplyEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ReplyRepository extends JpaRepository<ReplyEntity, Integer> {

    // 리스트 페이지 : findAll()
    // 뷰 페이지 : findById()
    // 수정 : save()
    // 입력 : save()

    // 삭제 : 별도 메소드 생성 -> int, @Transactional 반드시 추가
    @Transactional
    @Modifying
    @Query("delete from ReplyEntity r where r.rno = :rno")
    int deleteByRno(Integer rno);

    @Query("select r from ReplyEntity r where r.bno = :bno order by r.rno")
    List<ReplyEntity> findByBno(@Param("bno") Integer bno);



    // 게시글 삭제시 해당 게시물의 모든 댓글 삭제 처리
    @Transactional
    @Modifying
    @Query("delete from ReplyEntity r where r.bno = :bno")
    int deleteByBno(Integer bno);






}
