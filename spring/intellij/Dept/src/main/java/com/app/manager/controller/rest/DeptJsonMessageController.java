package com.app.manager.controller.rest;

import com.app.manager.domain.DeptDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Controller
public class DeptJsonMessageController {

    @GetMapping("/dept/json")
    @ResponseBody
    public List<DeptDTO> listJson(){

        List<DeptDTO> list = new ArrayList<>();
        list.add(new DeptDTO(10, "TEST10", "LOC10"));
        list.add(new DeptDTO(20, "TEST20", "LOC20"));
        list.add(new DeptDTO(30, "TEST30", "LOC30"));

        return list;
    }
}
