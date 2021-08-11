package com.example.boardapitwo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data // @Getter, @Setter, @ToString, @EqualsAndHashCode, @RequiredArgsConstructor를 포함한 어노테이션
public class BoardDTO {
    int seq;
    String title;
    String content;
    LocalDateTime reg_dt;


}
