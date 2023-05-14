package com.ssafy.enjoytrip.dto;

import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AttractionInfo {

    private String contentId;
    private String title;
    private String addr1;
    private String addr2;
    private String firstImage;
    private String firstImage2;
    private double latitude;
    private double longitude;
    private int readCount;
    private int likeCount;
    private String overview;
}
