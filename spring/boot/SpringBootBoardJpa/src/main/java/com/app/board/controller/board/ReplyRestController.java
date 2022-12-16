package com.app.board.controller.board;

import com.app.board.domain.ReplyDTO;
import com.app.board.entity.ReplyEntity;
import com.app.board.service.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/reply")
public class ReplyRestController {

    @Autowired
    private ReplyListService replyListService;

    @Autowired
    private ReplyInsertService replyInsertService;

    @Autowired
    private ReplyReadService replyReadService;

    @Autowired
    private ReplyDeleteService replyDeleteService;

    @Autowired
    private ReplyEditService replyEditService;



    // get /reply/{bno} -> list 응답
    @GetMapping(value = "/{bno}",produces = MediaType.APPLICATION_JSON_VALUE) // 반환 타입에 대한 정의(JSON 형식이야)
    public ResponseEntity<List<ReplyEntity>> selectList(@PathVariable("bno")int bno){

        List<ReplyEntity> list = replyListService.selectAll(bno);

        return new ResponseEntity<>(list, HttpStatus.OK);

    }


    // post /reply -> reply 객체 그대로 전송     JSON 데이터를 받아서 DB에 insert
    // DB에서 사용하는 rno값을 받아와서 insert하는 relpy에 갱신
    @PostMapping
    public ResponseEntity<ReplyEntity> insertReply(@RequestBody ReplyEntity replyEntity){

        log.info( "insert 전 replyDTO : " + replyEntity);

        // Service -> Mapper
        replyInsertService.insertReply(replyEntity);

        log.info( "insert 후 replyDTO : " + replyEntity); // rno 값이 갱신된 데이터(행 하나를 추가해야 하므로)

        // 현재 날짜 저장
        //replyDTO.setReplyDate(LocalDate.now().toString());

        return new ResponseEntity<>(replyReadService.selectReplyByRno(replyEntity.getRno()), HttpStatus.OK);

    }


    // put /reply/{rno} -> reply
    @PutMapping("/{rno}")
    public ResponseEntity<ReplyEntity> editReply( @PathVariable("rno")int rno, @RequestBody ReplyEntity replyEntity){

        replyEntity.setRno(rno); // 자원의 위치를 표시
        return new ResponseEntity<>(replyEditService.updateReplyByRno(replyEntity), HttpStatus.OK);

    }


    // delete /reply/{rno} -> 결과 1(t)/0(f), success/fail
    @DeleteMapping("/{rno}")
    public ResponseEntity<ReplyEntity> deleteReply(@PathVariable("rno")int rno){

        replyDeleteService.deleteReplyByRno(rno);

        return new ResponseEntity<>(null, HttpStatus.OK);

    }


}
