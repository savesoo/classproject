package com.app.board.controller.emp;

import com.app.board.service.emp.EmpListService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
public class EmpListController {

    @Autowired
    private EmpListService empListService;


    @GetMapping("/emp/list")
    public void getList(Model model){

        //model.addAttribute("empList", empListService.getList());
        model.addAttribute("empList", empListService.getMgr());

    }


}
