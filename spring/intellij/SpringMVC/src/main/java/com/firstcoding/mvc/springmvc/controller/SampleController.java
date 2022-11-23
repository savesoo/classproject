package com.firstcoding.mvc.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SampleController {

    // 사용자에게 표시할 view 페이지 구성 방법 세 가지
    // 1. ModelAndView 타입으로 view path 지정
    @RequestMapping("/sample")
    public ModelAndView getSamplePage(){

        ModelAndView mav = new ModelAndView(); // 생성자
        mav.setViewName("sample"); // 경로를 지정 => /WEB-INF/views/sample.jsp

        return mav;
    }

    // 2. String 타입 사용
    @RequestMapping("/sample2")
    public String getStringPage(){
        return "sample2"; // 경로 지정 => /WEB-INF/views/sample2.jsp
    }

    // 3. void 형식 사용
    @RequestMapping("/sample3")
    public void getVoidPage(){
    }

    @RequestMapping("/sample4")
    @ResponseBody
    public String page(){
        return "String Response ... "; // 반환데이터를 그대로 응답처리하는 ResponseBody
    }

    @RequestMapping("/sample5")
    @ResponseBody
    public String page2(int num){

        // 에러 띄우기 위한 코드처리
        String str = null;
        str.trim();

        return String.valueOf(num);
    }
}
