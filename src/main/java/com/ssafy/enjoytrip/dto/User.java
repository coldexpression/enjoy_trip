package com.ssafy.enjoytrip.dto;

import lombok.*;

@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String id;
    private String pwd;
    private String email;
    private boolean advertisement;
}
