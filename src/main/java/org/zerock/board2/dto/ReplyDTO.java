package org.zerock.board2.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ReplyDTO {
    

    private Long rno;
    private Long bno;
    private String reply;
    private String replyer;
    @Builder.Default 
    private Long gno = 0L;
    
    private int step;

    private LocalDate replyDate;

}
