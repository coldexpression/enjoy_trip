package com.ssafy.enjoytrip.model.service;

import com.ssafy.enjoytrip.dto.AttractionInfo;

import java.util.List;

public interface AttractionInfoService {
    List<AttractionInfo> selectAll();

    List<AttractionInfo> selectTop4();

    List<AttractionInfo> selectByTitle(String searchTitle);

    AttractionInfo selectByContentID(String contentId);

    void likeCountUp(String contentId);
}
