package com.first.app.entity;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name="dept")
public class Dept {

    @Id // 필수
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql mariaDB auto Increment일 때 등록
    @Column
    private Integer deptno; // 양수만 받을 수 있으므로 int 아닌 Integer 타입으로 받음

    @Column(length = 20, nullable = false)
    private String dname;

    @Column(length = 20, nullable = false)
    private String loc;
}
