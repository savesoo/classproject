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
@Table(name="tbl_board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer bno;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 2000, nullable = false)
    private String content;
/*    @Column(nullable = false, updatable = false)
    private String writer;*/

    @ManyToOne
    @JoinColumn(name = "writer")
    private BoardMemberEntity writer;

    @Column(length = 90)
    private String photo;

    @Column(name = "regdate", insertable = false, updatable = false)
    private LocalDate regDate;

    @Column(name = "updatedate",insertable = false)
    private LocalDate updateDate;

}
