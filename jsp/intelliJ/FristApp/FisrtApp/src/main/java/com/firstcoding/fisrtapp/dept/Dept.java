package com.firstcoding.fisrtapp.dept;

import lombok.*;

@AllArgsConstructor // 생성자 생성
@NoArgsConstructor // 매개변수 없는 기본생성자 생성
@Getter
@Setter
@ToString
@Builder
public class Dept {

    private int deptno;
    private String dname;
    private String loc;


}
