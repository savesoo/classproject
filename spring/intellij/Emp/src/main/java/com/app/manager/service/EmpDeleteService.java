package com.app.manager.service;

import com.app.manager.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpDeleteService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    public int deleteEmp(int empno){
       return empMapper.deleteEmp(empno);
    }
}
