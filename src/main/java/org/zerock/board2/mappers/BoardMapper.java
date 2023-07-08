package org.zerock.board2.mappers;

import java.util.List;

import org.zerock.board2.dto.BoardDTO;
import org.zerock.board2.dto.PageRequestDTO;

public interface BoardMapper {
    
    // 모든 리스트를 가져오는 맵퍼
    List<BoardDTO> getList(PageRequestDTO pageRequestDTO);
    // 1개의 게시글을 가져오는 맵퍼
    BoardDTO getOne(Integer bno);
    // 게시글을 추가하는 맵퍼
    int insertOne(BoardDTO boardDTO);
    // 게시글을 삭제하는 맵퍼
    int deleteOne(Integer bno);
    // 게시글을 수정하는 맵퍼
    int modifyOne(BoardDTO boardDTO);
    // 1번에 리스트 몇개씩가져오는지 알려주는 맵퍼
    long listCount(PageRequestDTO pageRequestDTO);
}
