package com.ssafy.enjoytrip.dto;

import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AttractionInfo {

    private String content_id;
    private String title;
    private String addr;
    private String img1;
    private String img2;
    private double latitude;
    private double longitude;

}
