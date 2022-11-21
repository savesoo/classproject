package com.mytodolist.springtodo.domain;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UserDTO {

    private String userID;
    private String userPW;
    private String checkPW;
    private String userName;
    private MultipartFile userProfile;

}
