package com.app.manager.mapper;

import com.app.manager.domain.EmpDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpMapper {

    // 사원 리스트 조회
    List<EmpDTO> selectAll();

    // 사원 입력
    int insertEmp(EmpDTO empDTO);

    // 사원 조회
    EmpDTO selectByEmpno(int empno);

    // 사원 정보 수정
    int updateEmp(EmpDTO empDTO);

    // 사원 퇴사
    int deleteEmp(int empno);

}
