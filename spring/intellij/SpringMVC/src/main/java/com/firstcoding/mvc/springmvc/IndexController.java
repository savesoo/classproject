package com.firstcoding.mvc.springmvc;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
public class IndexController {

    @RequestMapping("/index") // 어떻게 요청했을 때 이 메소드를 실행할 거니? /index 로 들어왔을 때
    public void getIndex(){

       log.info("Index page ... ");
    }

    // void로 정의된 메소드가 사용할 view -> 등록한 url을 반환(= /WEB-INF/views/index.jsp

}
