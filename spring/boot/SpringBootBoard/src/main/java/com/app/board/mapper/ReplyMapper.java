package com.app.board.mapper;

import com.app.board.domain.ReplyDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReplyMapper {

    @Select("SELECT * FROM tbl_reply WHERE bno=#{bno}")
    List<ReplyDTO> selectAll(int bno);

    @Select("SELECT * FROM tbl_reply WHERE rno=#{rno}")
    ReplyDTO selectReplyByRno(int rno);

    @Insert("INSERT INTO tbl_reply (bno, reply, replyer) VALUES (#{bno}, #{reply}, #{replyer})")
    @Options(useGeneratedKeys = true, keyProperty = "rno", keyColumn = "rno")
              // 자동생성된 것을 사용함(true), key가 되는 속성값, key 컬럼명
    Integer insertReply(ReplyDTO replyDTO);


    @Delete("DELETE FROM tbl_reply WHERE rno=#{rno}")
    Integer deleteReplyByRno(int rno);


    @Update("UPDATE tbl_reply SET bno=#{bno}, reply=#{reply}, replyer=#{replyer}, replyDate=#{replyDate}, updateDate=now() WHERE rno=#{rno}")
    int updateReplyByRno(ReplyDTO replyDTO);


}
