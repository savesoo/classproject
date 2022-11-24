package com.app.manager.service;

import com.app.manager.domain.EmpDTO;
import com.app.manager.mapper.DeptMapper;
import com.app.manager.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class EmpEditService {

    @Autowired(required = false)
    private EmpMapper empMapper;

    @Autowired(required = false)
    private DeptMapper deptMapper;

    public int updateEmp(EmpDTO empDTO){
        return empMapper.updateEmp(empDTO);
    }

}
