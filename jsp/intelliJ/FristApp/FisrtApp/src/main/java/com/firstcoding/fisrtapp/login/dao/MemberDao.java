package com.firstcoding.fisrtapp.login.dao;

import com.firstcoding.fisrtapp.login.domain.Member;

import java.sql.Connection;
import java.sql.SQLException;

public interface MemberDao {

    // 회원가입
    int insertMember(Connection conn, Member member) throws SQLException;

    // 회원 존재 여부 확인
    Member selectByUidPw(Connection conn, String uid, String pw) throws SQLException;

    // uuid DB에 저장
    int updateUUIDByIdx(Connection conn, String uuid, int idx) throws SQLException;

    Member selectByUUID(Connection conn, String uuid) throws SQLException;

}
