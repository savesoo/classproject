package com.mytodolist.springtodo.mapper;

import com.mytodolist.springtodo.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    int selectCount();
    // 로그인
    UserDTO selectByIDPW(UserDTO user);

    //회원가입 -> user table에 insert
    int insertUser(UserDTO user); // signup 처리....?????

    // 자동 로그인 기능
    // DB에 저장된 uuid로 user 정보 가져오기
    UserDTO selectUUID(String uuid);

    // 갱신된 uuid값 DB로 업데이트
    int updateUUID(UserDTO user);

}
