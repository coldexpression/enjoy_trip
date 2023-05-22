package com.ssafy.enjoytrip.model.service;

import com.ssafy.enjoytrip.dto.AttractionInfo;

import java.util.List;

public interface AttractionInfoService {
    List<AttractionInfo> selectAll();

    List<AttractionInfo> selectTop4();

    List<AttractionInfo> selectByTitle(String searchTitle);

    List<AttractionInfo> selectBySidoCode(String sidoCode);

    AttractionInfo selectByContentID(String contentId);

    List<AttractionInfo> userFavoriteList(String userId);

    void likeCountUp(String contentId, String userId, String name);

    void likeCountDown(String contentId, String userId);

}
