package org.zerock.board2.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.board2.dto.PageRequestDTO;
import org.zerock.board2.dto.PageResponseDTO;
import org.zerock.board2.dto.ReplyDTO;

@Transactional
public interface ReplyService {
    


    Long insertReply(ReplyDTO replyDTO);


    ReplyDTO readReply(Long rno);


    PageResponseDTO<ReplyDTO> replyList(@Param("page") PageRequestDTO requestDTO, @Param("tno") Long tno );


    int replyDelete(Long rno);


    int updateReply(ReplyDTO replyDTO);
}
