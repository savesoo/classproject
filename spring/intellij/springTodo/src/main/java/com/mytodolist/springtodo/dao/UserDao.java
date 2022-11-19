package com.mytodolist.springtodo.dao;

import com.mytodolist.springtodo.domain.UserDTO;
import lombok.Cleanup;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    // 로그인
    public int selectByIDPW(Connection conn, UserDTO user) throws SQLException {

        int result = 0;

        String sql = "select * from todo_user where userID=? and userPW=?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, user.getUserID());
        pstmt.setString(2, user.getUserPW());

        @Cleanup ResultSet rs = pstmt.executeQuery();

        if(rs.next()){
            result++;
        }

        return result;

    }

    //회원가입 -> user table에 insert
    public int insertUser(Connection conn, UserDTO user) throws SQLException{

        String sql = "insert into todo_user(userID, userPW, userName) values (?, ?, ?)";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, user.getUserID());
        pstmt.setString(2, user.getUserPW());
        pstmt.setString(3, user.getUserName());
        return pstmt.executeUpdate();

    }

}
