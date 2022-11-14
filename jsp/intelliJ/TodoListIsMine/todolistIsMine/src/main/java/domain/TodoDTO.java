package domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class TodoDTO {

    private long tno;
    private String todo;
    private String dueDate;
    private boolean finished;
    
}
