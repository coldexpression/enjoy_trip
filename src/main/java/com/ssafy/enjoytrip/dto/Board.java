package com.ssafy.enjoytrip.dto;
import lombok.*;
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    private  int num;
    private String userID;
    private String title;
    private String content;
    private int readCount;
}
