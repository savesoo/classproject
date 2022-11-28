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
public class UserDTO {

    @NotEmpty(message = "ID는 비워둘 수 없습니다.")
    private String userID;
    @NotEmpty(message = "패스워드를 입력해 주세요.")
    private String userPW;
    private String checkPW;
    private String userName;
    private int user_idx;
    private String uuid;
    private String userProfile; // DB와 연결되는 항목


    // 로그인 정보를 확인
    public LoginInfo toLoginInfo(){
        return LoginInfo.builder()
                .user_idx(this.user_idx)
                .userID(this.userID)
                .userName(this.userName)
                .userProfile(this.userProfile)
                .uuid(this.uuid)
                .build();
    }
}
