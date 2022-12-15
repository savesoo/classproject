package com.first.app.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name="emp")
public class Emp {

    @Id // 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql mariaDB auto Increment일 때 등록
    @Column
    private Integer empno;

    @Column
    private String ename;

    @Column
    private String job;

    @Column
    private Integer mgr; // 상사의 사원번호

    @Column
    private LocalDate hiredate;

    @Column
    private Double sal; // null 들어올 수 있으므로 wrapper class인 double 사용!!

    @Column
    private Double comm;

   /* @Column
    private Integer deptno;*/


    @JoinColumn(name="deptno") // 무엇을 외래키로 join할 것인가
    @ManyToOne // emp-dept 사이의 관계를 나타냄 = dept가 여러개(Many) <-> @OneToMany
    private Dept dept; // Dept는 Entity

}
