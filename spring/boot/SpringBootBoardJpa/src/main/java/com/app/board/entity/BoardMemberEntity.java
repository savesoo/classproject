package com.app.board.entity;

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
@Table(name = "boardmember")
public class BoardMemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idx;

    @Column
    private String userid;

    @Column
    private String password;

    @Column
    private String username;

    @Column
    private String role; // 기본값 USER

    @Column
    private LocalDate regdate;

    @Column
    private LocalDate editdate;



}
