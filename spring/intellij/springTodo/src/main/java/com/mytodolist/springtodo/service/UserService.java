package com.mytodolist.springtodo.service;

import com.mytodolist.springtodo.dao.UserDao;
import com.mytodolist.springtodo.domain.SignUpDTO;
import com.mytodolist.springtodo.domain.UserDTO;
import com.mytodolist.springtodo.util.ConnectionUtil;
import lombok.Cleanup;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@Log4j2
@Service
public class UserService implements ITodo{

    private final UserDao dao;

    public UserService(UserDao dao) {
        this.dao = dao;
    }

    // id, pw로 로그인
    public UserDTO loginByIDPW(String userID, String userPW) throws SQLException {

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.selectByIDPW(conn, userID, userPW);

    }


    // 회원가입
    public int checkFileAndSignUp(SignUpDTO signup, HttpServletRequest request) throws SQLException {

        String newFileName = null;

        // 파일 업로드 여부 확인
        if (signup.getUserProfile()!=null
                && !signup.getUserProfile().isEmpty()
                && signup.getUserProfile().getSize()>0) {

            // URI 정의
            String dirURI = "/uploadfile/userfile";
            // 시스템의 절대 경로
            String dirRealPath = request.getSession().getServletContext().getRealPath(dirURI);

            // 저장하기 전에 새로운 이름으로 만들어 저장 - 중복 방지
            newFileName = signup.getUserName() + "_" + signup.getUserProfile().getOriginalFilename();
            log.info(newFileName);

            // 저장
            try {
                signup.getUserProfile().transferTo(new File(dirRealPath, newFileName));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        UserDTO user = signup.toUser();

        if(newFileName!=null){
            user.setUserProfile(newFileName);
        }

        @Cleanup Connection conn = ConnectionUtil.getInstance().getConnection();

        return dao.insertUser(conn, user);

    }


}
