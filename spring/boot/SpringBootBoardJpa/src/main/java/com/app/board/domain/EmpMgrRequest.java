package com.app.board.domain;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class EmpMgrRequest {

    private int empno;
    private String ename;
    private String mname; // mgr 이름으로 출력
    private String dname; // deptno 이름으로 출력
    private LocalDate hiredate;
    private String job;
    private float sal;
    private float comm;

    public EmpDTO toEmpDTO(){
        return EmpDTO.builder()
                .empno(empno)
                .ename(ename)
                .job(job)
                .hiredate(hiredate)
                .sal(sal)
                .comm(comm)
                .build();
    }

}
