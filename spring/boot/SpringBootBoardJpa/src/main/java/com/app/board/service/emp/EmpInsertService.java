package com.app.board.service.emp;

import com.app.board.domain.EmpDTO;
import com.app.board.mapper.EmpMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class EmpInsertService {

    @Autowired
    private EmpMapper empMapper;

    public int insertEmp(EmpDTO empDTO){
        return empMapper.insertEmp(empDTO);
    }

}
