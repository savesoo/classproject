package com.first.app.entitly;


import org.springframework.data.jpa.repository.JpaRepository;

public interface DeptRepository extends JpaRepository<Dept, Integer> {

    // DeptRepository를 주입만 받으면 됨!!!!


}
