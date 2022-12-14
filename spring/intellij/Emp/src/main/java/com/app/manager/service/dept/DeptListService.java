package com.app.manager.service.dept;

import com.app.manager.domain.DeptDTO;
import com.app.manager.mapper.DeptMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class DeptListService {

    @Autowired(required = false)
    private DeptMapper deptMapper;

    public List<DeptDTO> getList(){
        return deptMapper.selectAll();
    }
}
