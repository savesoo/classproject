package com.app.manager.service;

import com.app.manager.domain.EmpDTO;
import com.app.manager.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpReadService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    public EmpDTO selectByEmpno(int empno){
        return empMapper.selectByEmpno(empno);
    }
}
