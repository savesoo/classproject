package dao;

import domain.UserDTO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    // 로그인
    public int selectByIDPW(Connection conn, UserDTO ud) throws SQLException {

        int result = 0;

        String sql = "select * from todo_user where userID=? and userPW=?";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, ud.getUserID());
        pstmt.setString(2, ud.getUserPW());

        @Cleanup ResultSet rs = pstmt.executeQuery();

        if(rs.next()){
            result++;
        }

        return result;

    }

    //회원가입
    public int signUpTodo(Connection conn, UserDTO ud) throws SQLException{

        int result = 0;

        String sql = "insert into todo_user(userID, userPW, userName) values (?, ?, ?)";

        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, ud.getUserID());
        pstmt.setString(2, ud.getUserPW());
        pstmt.setString(3, ud.getUserName());
        result = pstmt.executeUpdate();

        return result;
    }

}
