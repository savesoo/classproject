package com.first.app.entity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeptRepository extends JpaRepository<Dept, Integer> {

    // DeptRepository를 Service에 주입만 받으면 됨!!!!

    Dept findByDeptno(Integer deptno);

    List<Dept> findByDnameLikeOrderByLocAsc(String dname);

    List<Dept> findByDeptnoGreaterThanAndDnameLikeAndLocLikeOrderByDeptnoDesc(Integer deptno, String dname, String loc);


    @Query(value = "select d from Dept d where d.loc like :loc", nativeQuery = true)
    List<Dept> findByLocLike(@Param("loc") String loc);


    @Query("select d from Dept d where d.deptno between :startNum and :endNum")
    List<Dept> findByDeptnoBetween(@Param("startNum") Integer startNum, @Param("endNum") Integer endNum);




}
