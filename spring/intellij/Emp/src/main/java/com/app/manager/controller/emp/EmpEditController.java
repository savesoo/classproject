package com.app.manager.controller.emp;

import com.app.manager.domain.EmpDTO;
import com.app.manager.domain.JobListDTO;
import com.app.manager.service.emp.EmpEditService;
import com.app.manager.service.emp.EmpListService;
import com.app.manager.service.emp.EmpReadService;
import com.app.manager.service.dept.DeptListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Log4j2
@Controller
@RequestMapping("emp/edit")
public class EmpEditController {

    @Autowired(required = false)
    private EmpReadService empReadService;

    @Autowired(required = false)
    private EmpEditService empEditService;

    @Autowired(required = false)
    private DeptListService deptListService;

    @Autowired(required = false)
    private EmpListService empListService;

    @GetMapping
    public void getEditForm(@RequestParam("empno") int empno, Model model){
        log.info("get emp editForm >>>> ");
        model.addAttribute("saved", empReadService.selectByEmpno(empno));
        model.addAttribute("deptList", deptListService.getList()); // 필요한 데이터 사용을 위해 가져옴(deptno + dname)
        model.addAttribute("mgrList", empListService.getEmpList()); // mgr
        model.addAttribute("jobList", new JobListDTO().getJobList());


    }

    @PostMapping
    public String postEdit(EmpDTO empDTO){
        log.info("post edit >>>> ");
        log.info(empDTO);

        empEditService.updateEmp(empDTO);

        return "redirect:/emp/list";

    }



}
