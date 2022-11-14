package service;

import dao.UserDao;
import domain.UserDTO;
import lombok.Cleanup;
import util.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;

public class UserService implements ITodo{

    public boolean loginByIDPW(UserDTO userDTO) throws SQLException {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();
        boolean isLogin = false;

        if(ud.selectByIDPW(conn, userDTO) == 1){
            isLogin = true;
        }

        return isLogin;

    }
}
