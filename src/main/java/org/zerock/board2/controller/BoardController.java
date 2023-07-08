package org.zerock.board2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.board2.dto.BoardDTO;
import org.zerock.board2.dto.PageRequestDTO;
import org.zerock.board2.dto.PageResponseDTO;
import org.zerock.board2.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/board")
public class BoardController {
    
    private final BoardService service;

    @GetMapping("/list")
    public void getList(PageRequestDTO pageRequestDTO, Model model){
        
         PageResponseDTO<BoardDTO> responseDTO 
        = service.getList(pageRequestDTO);


        log.info("get List");
        
        model.addAttribute("dto", responseDTO);
    }

    @GetMapping("/read/{bno}")
    public String getRead(@PathVariable("bno") Integer bno, PageRequestDTO pageRequestDTO, Model model){

        log.info("get Read");

        model.addAttribute("dto", service.getOne(bno));

        return "/board/read";
    }
    @GetMapping("/regist")
    public void getRegist(BoardDTO boardDTO){
        log.info("get regist");
    }

    @GetMapping("/modify/{bno}")
    public String getModify(@PathVariable("bno") Integer bno,  PageRequestDTO pageRequestDTO,Model model){

        log.info("get modify");
        model.addAttribute("dto", service.getOne(bno));

        return "/board/modify";
    }

    @PostMapping("/regist")
    public String postRegist(BoardDTO boardDTO){

        log.info("post regist...");

        service.insertOne(boardDTO);
        
        return "redirect:/board/list";
    }

    @PostMapping("/modify")
    public String postModify(BoardDTO boardDTO, RedirectAttributes rttr){

        log.info("post modify....");
        service.modifyOne(boardDTO);
        rttr.addFlashAttribute("message", boardDTO.getBno() + "번 수정완료.");
        return "redirect:/board/read/" + boardDTO.getBno();
    }

    @PostMapping("/delete/{bno}")
    public String postDelete(@PathVariable("bno")Integer bno, RedirectAttributes rttr){

        log.info("post delete..."); 
        service.deleteOne(bno);
        rttr.addFlashAttribute("message",bno + "번 삭제완료.");
        return "redirect:/board/list";
    }
    
}
