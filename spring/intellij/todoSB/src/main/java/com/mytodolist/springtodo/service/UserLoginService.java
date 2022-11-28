package com.mytodolist.springtodo.service;

import com.mytodolist.springtodo.domain.UserDTO;
import com.mytodolist.springtodo.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.tools.jinfo.JInfo;


import java.sql.SQLException;

@Log4j2
@Service
public class UserLoginService {

    @Autowired(required = false)
    private UserMapper userMapper;

    // 로그인 (ID, PW)
    public UserDTO loginByIDandPW(String userID, String userPW) throws SQLException {
        UserDTO user = UserDTO.builder()
                .userID(userID)
                .userPW(userPW)
                .build();
        log.info(user);
        return userMapper.selectByIDPW(user);
    }

    // uuid로 user 정보 가져오기
    public UserDTO selectUUID(String uuid) throws SQLException {

        return userMapper.selectUUID(uuid);

    }

    // idx 찾아 uuid 갱신
    public int updateUUID(String uuid, int user_idx) throws SQLException  {

        UserDTO user = UserDTO.builder()
                .uuid(uuid)
                .user_idx(user_idx)
                .build();

        log.info(user);
        return userMapper.updateUUID(user);

    }
}
