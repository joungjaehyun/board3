package org.zerock.board2.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
public class PageResponseDTO<E> {
    
    private List<E> list;

    private long totalPage;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(List<E> list, long totalPage) {

        this.list = list;
        this.totalPage = totalPage;
    }
}
