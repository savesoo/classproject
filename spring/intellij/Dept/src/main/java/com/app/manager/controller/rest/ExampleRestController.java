package com.app.manager.controller.rest;

import com.app.manager.domain.DeptDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@RestController // @ResponseBody 없어도 해당 기능 수행 가능, 일반 view 페이지와 같이 사용할 때는 Response~
@RequestMapping("/test")
public class ExampleRestController {


    // 메소드의 반환타입이 String인 경우 문자열 형태로 응답
    @GetMapping("/sample1")
    public String sayHello() {
        return "Hello~Hello~";
    }


    // 꼭 JSON이 아니어도 문자열 형태로 응답할 수 있다~!
    // 객체의 반환은 JSON 형식으로 응답
    @GetMapping("/sample2")
    public DeptDTO getDept(){
        DeptDTO deptDTO = DeptDTO.builder()
                .deptno(90)
                .dname("DEV")
                .loc("SEOUL")
                .build();

        return deptDTO;
    }


    @GetMapping("/sample3")
    public List<DeptDTO> getDeptList(){

        List<DeptDTO> list = new ArrayList<>();
        list.add(new DeptDTO(10, "TEST10", "LOC10"));
        list.add(new DeptDTO(20, "TEST20", "LOC20"));
        list.add(new DeptDTO(30, "TEST30", "LOC30"));
        list.add(new DeptDTO(40, "TEST40", "LOC40"));

        return list;
    }


    @GetMapping("/sample4")
    public Map<Integer, DeptDTO> getDeptMap(){

         Map<Integer, DeptDTO> map = new HashMap<>();
         map.put(10, new DeptDTO(10, "TEST10", "LOC10"));
         map.put(20, new DeptDTO(20, "TEST10", "LOC10"));
         map.put(30, new DeptDTO(30, "TEST10", "LOC10"));
         map.put(40, new DeptDTO(40, "TEST10", "LOC10"));
         map.put(50, new DeptDTO(50, "TEST10", "LOC10"));
           // { "key1" : { value1 }, "key2" : { value2 }, .... } 형식으로 저장됨
         return map;
    }

}