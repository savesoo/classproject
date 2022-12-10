package com.app.board.domain;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmpDTO {

    private int empno;
    private String ename;
    private String job;
    private int mgr;
    private LocalDate hiredate;
    private float sal;
    private float comm;
    private int deptno;

}
