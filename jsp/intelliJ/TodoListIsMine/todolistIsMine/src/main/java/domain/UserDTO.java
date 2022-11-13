package domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UserDTO {

    private String userID;
    private String userPW;
    private String userName;

}
