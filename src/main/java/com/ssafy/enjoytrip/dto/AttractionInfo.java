package com.ssafy.enjoytrip.dto;

import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AttractionInfo {

    private String content_id;
    private String title;
    private String addr1;
    private String addr2;
    private String first_image;
    private String first_image2;
    private double latitude;
    private double longitude;
    private int view_count;
    private String overview;
}
