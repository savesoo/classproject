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
@Table(name="tbl_reply")
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer rno;

    @Column(nullable = false)
    private Integer bno;
    @Column(length = 1000, nullable = false)
    private String reply;
    @Column(length = 50, nullable = false)
    private String replyer;
    @Column(name = "replydate")
    private LocalDate replyDate;
    @Column(name = "updatedate")
    private LocalDate updateDate;


}
