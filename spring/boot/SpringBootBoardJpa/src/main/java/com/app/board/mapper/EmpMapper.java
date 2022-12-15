package com.app.board.mapper;

import com.app.board.domain.EmpDTO;
import com.app.board.domain.EmpMgrRequest;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("SELECT * FROM emp")
    List<EmpDTO> selectAll();

    @Select("SELECT m.ename as mname, d.dname as dname, e.* FROM emp e LEFT JOIN emp m ON e.mgr=m.empno LEFT JOIN dept d ON e.deptno = d.deptno")
    List<EmpMgrRequest> selectMgrNameByEmpno();

    @Insert("insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno ) values (#{empno}, #{ename}, #{job}, #{mgr}, #{hiredate}, #{sal}, #{comm}, #{deptno})")
    Integer insertEmp(EmpDTO empDTO);




}
