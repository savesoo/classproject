package com.app.board.service.emp;

import com.app.board.domain.EmpDTO;
import com.app.board.domain.EmpMgrRequest;
import com.app.board.mapper.EmpMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class EmpListService {

    @Autowired
    private EmpMapper empMapper;

    public List<EmpDTO> getList(){
        return empMapper.selectAll();
    }

    public List<EmpMgrRequest> getMgr(){
        return empMapper.selectMgrNameByEmpno();
    }
}
