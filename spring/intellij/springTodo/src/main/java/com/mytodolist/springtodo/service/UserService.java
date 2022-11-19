package com.mytodolist.springtodo.service;

import com.mytodolist.springtodo.dao.UserDao;
import com.mytodolist.springtodo.domain.UserDTO;
import com.mytodolist.springtodo.util.ConnectionUtil;
import lombok.Cleanup;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;

@Service
public class UserService implements ITodo{

    private final UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    // id, pw로 로그인
    public boolean loginByIDPW(UserDTO userDTO) throws SQLException {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();
        boolean isLogin = false;

        if(dao.selectByIDPW(conn, userDTO) == 1){
            isLogin = true;
        }

        return isLogin;

    }


    // 회원가입
    public int signupTodoUser(UserDTO userDTO) throws SQLException {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        int result = dao.insertUser(conn, userDTO);

        return result;
    }


}
