package com.firstcoding.mvc.springmvc.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@Controller
public class SearchController {

    @RequestMapping("/search/search")
    public String searchForm(){
        return "searchForm";
    }

    // Mapping 메소드 두 개 있어도 공유 되는지 확인
    @RequestMapping("/board/board")
    public String board(){
        return "board";
    }


    // 같은 클래스 내부에 존재하는 Mapping 메소드에 "" 안의 이름으로 데이터 전달 가능 -> view로 공유됨!!
    @ModelAttribute("keywords")
    public String[] getKeywords(){
        return new String[] {"류정한", "팬텀", "차기작", "임혜영", "드라큘라"};
    }

    @ModelAttribute("searhType")
    public List<String> getSearchType(){

        List<String> list = new ArrayList<>();
        list.add("id");
        list.add("title");
        list.add("keyword");

        return list;
    }
}
