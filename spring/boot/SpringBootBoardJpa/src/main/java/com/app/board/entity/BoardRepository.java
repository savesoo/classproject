package com.app.board.entity;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BoardRepository extends JpaRepository<BoardEntity, Integer> {

    List<BoardEntity> findAllByBno(Integer bno);

    BoardEntity findByBno(Integer bno);

    @Query("select b from BoardEntity b where b.bno between :start and :end")
    List<BoardEntity> findByBnoBetween(@Param("start") Integer start, @Param("end") Integer end, Pageable pageable);


}
