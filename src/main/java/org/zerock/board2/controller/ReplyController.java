package org.zerock.board2.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.board2.dto.PageRequestDTO;
import org.zerock.board2.dto.PageResponseDTO;
import org.zerock.board2.dto.ReplyDTO;
import org.zerock.board2.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/replies/")
public class ReplyController {

    private final ReplyService replyService;

    @GetMapping("{bno}/list")
    public PageResponseDTO<ReplyDTO> getlist(@PathVariable("bno") Long bno, PageRequestDTO requestDTO) {
        return replyService.replyList(requestDTO, bno);
    }


    @PostMapping("{bno}/new")
    public Map<String, Long> insert(@PathVariable("bno") Long bno, @RequestBody ReplyDTO replyDTO) {
        replyDTO.setBno(bno);

        Long rno = replyService.insertReply(replyDTO);

        return Map.of("result", rno);
    }


    @GetMapping("{rno}")
    public ReplyDTO read(@PathVariable("rno") Long rno) {
        ReplyDTO replyDTO = replyService.readReply(rno);
        return replyDTO;
    }

  
    @DeleteMapping("{rno}")
    public Map<String, Integer> delete(@PathVariable("rno") Long rno) {
        int result = replyService.replyDelete(rno);
        return Map.of("result", result);
    }


    @PutMapping("modify")
    public Map<String, Integer> modify(@RequestBody ReplyDTO replyDTO) {
  
      
    
        int result = replyService.updateReply(replyDTO);
        return Map.of("result", result);
    }
}
