package org.zerock.board2.service;


import org.springframework.transaction.annotation.Transactional;
import org.zerock.board2.dto.BoardDTO;
import org.zerock.board2.dto.PageRequestDTO;
import org.zerock.board2.dto.PageResponseDTO;

@Transactional
public interface BoardService {
    
    PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO);
    BoardDTO getOne(Integer bno);
    void insertOne(BoardDTO boardDTO);
    void deleteOne(Integer bno);
    void modifyOne(BoardDTO boardDTO);
}
