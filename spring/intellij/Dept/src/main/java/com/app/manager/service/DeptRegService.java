package com.app.manager.service;

import com.app.manager.domain.DeptDTO;
import com.app.manager.mapper.DeptMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Log4j2
@Service
public class DeptRegService {

    @Autowired(required = false)
    private DeptMapper deptMapper;

    public int insertDept(DeptDTO deptDTO){
        return deptMapper.insertDept(deptDTO);
    }

    // 메소드 실행시 트랜잭션 처리하는 어노테이션
    @Transactional
    public int insertDepts(DeptDTO deptDTO){
        deptMapper.insertDept(deptDTO); // 중간에 오류 발생시 이 라인은 반영되지 않음
        //deptMapper.insertDept(new DeptDTO(10, "test", "test"));
        return 0;
    }
}
