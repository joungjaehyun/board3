package org.zerock.board2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.board2.dto.PageRequestDTO;
import org.zerock.board2.dto.PageResponseDTO;
import org.zerock.board2.dto.ReplyDTO;
import org.zerock.board2.mappers.ReplyMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class ReplyServiceImple implements ReplyService{

    private final ReplyMapper replyMapper;

    @Override
    public Long insertReply(ReplyDTO replyDTO) {

        Long result = null;
        Long gno = replyDTO.getGno();
        
        if(gno == 0L) {
            int count = replyMapper.insertReply(replyDTO);

            if(count != 1) {
                throw new RuntimeException("Error");
            }
            Long rno = replyDTO.getRno();
            replyMapper.updateGno(rno);
            result = rno;
        }
        else { 
            int count = replyMapper.insertReplyChild(replyDTO);
            if(count != 1) {
                throw new RuntimeException("insert error child");
            }
            result = replyDTO.getRno();
        }
        return result;
    }


    @Override
    public ReplyDTO readReply(Long rno) {
        
        return replyMapper.readReply(rno);
    }

    @Override
    public PageResponseDTO<ReplyDTO> replyList(PageRequestDTO requestDTO, Long tno) {
        requestDTO.setSize(100);

 
      List<ReplyDTO> list = replyMapper.replyList(requestDTO, tno);
   
      int total = replyMapper.total(tno);
 

      return PageResponseDTO.<ReplyDTO>withAll()
      .list(list)
      .totalPage(total)
      .build();

    }
    

    @Override
    public int replyDelete(Long rno) {
        
        return replyMapper.replyDelete(rno);
    }

    @Override
    public int updateReply(ReplyDTO replyDTO) {
        
        return replyMapper.updateReply(replyDTO);
    }
    
}