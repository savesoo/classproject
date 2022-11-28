package com.mytodolist.springtodo.domain;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class TodoDTO {

    private long tno;
    @NotEmpty
    private String todo;
    @NotEmpty
    @Future
    private LocalDate dueDate;
    private boolean finished;
    private String userID;

}
