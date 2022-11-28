package com.mytodolist.springtodo.dao;

import com.mytodolist.springtodo.domain.TodoDTO;
import com.mytodolist.springtodo.domain.UserDTO;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
@Repository
public class UserDao {

    // 로그인
    public UserDTO selectByIDPW(Connection conn, String userID, String userPW) throws SQLException {

        String sql = "select * from todo_user where userID=? and userPW=?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, userID );
        pstmt.setString(2, userPW);

        @Cleanup ResultSet rs = pstmt.executeQuery();

        UserDTO user = null;

        if(rs.next()){
            user = UserDTO.builder()
                    .userID(rs.getString("userID"))
                    .userPW(rs.getString("userPW"))
                    .userName(rs.getString("userName"))
                    .userProfile(rs.getString("userProfile"))
                    .build();
        }

        log.info(user);

        return user;

    }

    //회원가입 -> user table에 insert
    public int insertUser(Connection conn, UserDTO user) throws SQLException{

        String sql = "insert into todo_user(userID, userPW, userName, userProfile) values (?, ?, ?, ?)";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, user.getUserID());
        pstmt.setString(2, user.getUserPW());
        pstmt.setString(3, user.getUserName());
        pstmt.setString(4, user.getUserProfile());

        return pstmt.executeUpdate();

    }


    // 자동 로그인 기능
    // DB에 저장된 uuid로 user 정보 가져오기
    public UserDTO selectUUID(Connection conn, String uuid) throws SQLException {

        String sql = "select * from todo_user where uuid=?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, uuid);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        UserDTO user = null;

        if(rs.next()){
            user = UserDTO.builder()
                    .user_idx(rs.getInt("user_idx"))
                    .userID(rs.getString("userID"))
                    .userPW(rs.getString("userPW"))
                    .userName(rs.getString("userName"))
                    .uuid(rs.getString("uuid"))
                    .userProfile(rs.getString("userProfile"))
                    .build();
        }

        return user;
    }


    // 갱신된 uuid값 DB로 업데이트
    public int updateUUID(Connection conn, String uuid, int user_idx) throws SQLException {

        String sql = "update todo_user set uuid=? where user_idx=?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, uuid);
        pstmt.setInt(2, user_idx);

        int result = pstmt.executeUpdate();

        return result;
    }


//    public static UserDTO addRowToUser(ResultSet rs) throws SQLException{
//        return new UserDTO(rs.getString(1),
//                           rs.getString(2),
//                           rs.getString(3),
//                           rs.getString(4),
//                           rs.getInt(5),
//                           rs.getString(6),
//                           rs.getString(7));
//    }

}
