package com.mytodolist.springtodo.domain;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class LoginInfo {

    // 로그인시 가지고 다닐 데이터만 저장한 DTO
    @NotEmpty
    private int user_idx;
    @NotEmpty
    private String userID;
    @NotEmpty
    private String userName;
    private String userProfile;
    private String uuid;

}
