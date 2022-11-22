package com.mytodolist.springtodo.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class LoginInfo {

    // 로그인시 가지고 다닐 데이터만 저장한 DTO
    private String userID;
    private String userName;
    private String userProfile;

}
