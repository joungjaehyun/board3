package org.zerock.board2.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.board2.dto.BoardDTO;
import org.zerock.board2.dto.PageRequestDTO;

public interface BoardMapper {
    
    // 모든 리스트를 가져오는 맵퍼
    List<BoardDTO> getList(PageRequestDTO pageRequestDTO);
    // 1개의 게시글을 가져오는 맵퍼
    BoardDTO getOne(Long bno);
    // 게시글을 추가하는 맵퍼
    int insertOne(BoardDTO boardDTO);
    // 게시글을 삭제하는 맵퍼
    int deleteOne(Long bno);
    // 게시글을 수정하는 맵퍼
    int modifyOne(BoardDTO boardDTO);
    // 1번에 리스트 몇개씩가져오는지 알려주는 맵퍼
    long listCount(PageRequestDTO pageRequestDTO);
    // 조회수 추가
    int incremetViewCnt(Long bno);
    // 댓글수 기능
     public void updateReplyCnt(@Param("bno")Long bno, @Param("amount")
    int amount);
    
}
