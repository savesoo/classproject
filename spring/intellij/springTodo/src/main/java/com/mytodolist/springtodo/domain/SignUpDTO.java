package com.mytodolist.springtodo.domain;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class SignUpDTO {

    private String userID;
    private String userPW;
    private String checkPW;
    private String userName;
    private MultipartFile userProfile;


    // file 업로드시 data 충돌 방지
    public UserDTO toUser(){

        UserDTO user = UserDTO.builder()
                .userID(this.userID)
                .userPW(this.userPW)
                .userName(this.userName)
                .build();

        return user;
    }

}
