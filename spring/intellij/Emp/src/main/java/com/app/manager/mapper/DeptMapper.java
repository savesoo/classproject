package com.app.manager.mapper;

import com.app.manager.domain.DeptDTO;
import com.app.manager.domain.DeptSearchOption;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    // 전체 부서 리스트
    List<DeptDTO> selectAll();

    // 입력
    int insertDept(DeptDTO deptDTO);

    // 수정, 상세 페이지
    DeptDTO selectBydeptno(int deptno);

    // 수정(변경) 처리
    int updateDept(DeptDTO deptDTO);

    // 삭제
    int deletBydeptno(int deptno);

    // ++
    // 검색 타입과 키워드를 받아서 검색 결과를 반환
    List<DeptDTO> selectByOption(DeptSearchOption deptSearchOption);


}
