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
@Table(name="board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer bno;

    @Column(length = 200, nullable = false)
    private String title;
    @Column(length = 2000, nullable = false)
    private String content;
    @Column(length = 50, nullable = false)
    private String writer;
    @Column(length = 90)
    private String photo;

    @Column
    private LocalDate regDate;
    @Column
    private LocalDate updateDate;

}
