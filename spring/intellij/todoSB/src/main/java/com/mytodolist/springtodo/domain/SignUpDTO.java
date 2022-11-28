package com.mytodolist.springtodo.domain;


import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class SignUpDTO {

    @NotEmpty(message = "ID는 비워둘 수 없습니다.")
    private String userID;
   @NotEmpty(message = "패스워드를 입력해 주세요.")
    private String userPW;
   @NotEmpty(message = "동일한 패스워드를 재입력 해주세요.")
    private String checkPW;
    @NotEmpty
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
