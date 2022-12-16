package com.app.springsecurity.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Member {

    @Id
    private String email;

    @Column
    private String password;
    @Column
    private String name;

    // 상관관계 표현 : 여기서는 ManyToOne -> Member의 email을 외래키로 하는 테이블 생성
    @ElementCollection(fetch = FetchType.EAGER) // Lazy : 기다렸다가 마지막에 한번 실행해주는 설정
    private Set<MemberRole> roleSet;

    public void addMemberRole(MemberRole role){
        roleSet.add(role); // set도 collection이라 add 사용 가능
    }

}
