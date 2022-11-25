package com.app.manager.service.emp;

import com.app.manager.domain.EmpDTO;
import com.app.manager.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpRegService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    public int insertEmp(EmpDTO empDTO){
        return empMapper.insertEmp(empDTO);
    }
}
