package com.app.board.controller.board;

import com.app.board.security.CustomUser;
import com.app.board.service.board.BoardViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardViewController {

    @Autowired
    private BoardViewService boardViewService;

    @GetMapping("/board/view")
    public void readArticle(@RequestParam("bno") int bno,
                            @RequestParam("p") int p,
                            Model model,
                            @AuthenticationPrincipal CustomUser customUser
    ){
        model.addAttribute("currentPageNum", p);
        model.addAttribute("boardView", boardViewService.selectBoardEntity(bno));


        // CustomUser : 현재 로그인한 사용자의 정보를 가진 객체
        // CustomUser.boardMember
        model.addAttribute("midx", customUser.getBoardMember().getIdx()); // 이 외에 thymeleaf로 principal 가져오는 방법

    }

}
