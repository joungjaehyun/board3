package org.zerock.board2.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.board2.dto.PageRequestDTO;
import org.zerock.board2.dto.ReplyDTO;

public interface ReplyMapper {

    int insertReply(ReplyDTO replyDTO);

    //대댓글일떄
    int insertReplyChild(ReplyDTO replyDTO);

    // gno값 일치
    int updateGno(Long gno);

    // 1개의 게시글읽기 
    ReplyDTO readReply(Long rno);

    // 댓글을 게시글에서 가져오기
    List<ReplyDTO> replyList(@Param("page") PageRequestDTO requestDTO, @Param("bno") Long bno );

    // total 
    int total(Long bno);

    // reply delete 
    int replyDelete(Long rno);

    // reply update 
    int updateReply(ReplyDTO replyDTO);

    
}