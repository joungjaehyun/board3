package org.zerock.board2.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.board2.dto.BoardDTO;
import org.zerock.board2.dto.PageRequestDTO;
import org.zerock.board2.dto.PageResponseDTO;
import org.zerock.board2.mappers.BoardMapper;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class BoardServiceImple implements BoardService{

    private final BoardMapper boardMapper;

    @Override
    public PageResponseDTO<BoardDTO> getList(PageRequestDTO pageRequestDTO) {
        
        List<BoardDTO> list = boardMapper.getList(pageRequestDTO);
        long total = boardMapper.listCount(pageRequestDTO);

        return PageResponseDTO.<BoardDTO>withAll()
            .list(list)
            .totalPage(total)
            .build();
    }

    @Override
    public BoardDTO getOne(Long bno) {
        
        return boardMapper.getOne(bno);
    }

    @Override
    public void insertOne(BoardDTO boardDTO) {

        boardMapper.insertOne(boardDTO);
    }

    @Override
    public void deleteOne(Long bno) {
       boardMapper.deleteOne(bno);
    }

    @Override
    public void modifyOne(BoardDTO boardDTO) {
        boardMapper.modifyOne(boardDTO);
    }

    @Override
    public void addViewCnt(Long bno) {
        boardMapper.incremetViewCnt(bno);
    }
    
}
