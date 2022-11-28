package com.mytodolist.springtodo.service;

import com.mytodolist.springtodo.domain.SignUpDTO;
import com.mytodolist.springtodo.domain.UserDTO;
import com.mytodolist.springtodo.mapper.UserMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@Service
public class SingUpService {

    @Autowired(required = false)
    private UserMapper userMapper;

     // 회원가입
    @Transactional
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


        return userMapper.insertUser(user);

    }

}
