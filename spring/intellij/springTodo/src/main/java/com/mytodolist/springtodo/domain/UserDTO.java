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
