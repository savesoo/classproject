package com.app.board.repository;

import com.app.board.entity.BoardMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardMemberRepository extends JpaRepository<BoardMemberEntity, Integer> {

    // 회원 정보 하나 찾기 -> CustomUserDetailService
    //                    (회원의 정보, 권한 정보를 가지는 CustomUser 반환)
    Optional<BoardMemberEntity> findByUserid(String userid);


}
