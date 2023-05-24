package com.ssafy.enjoytrip.model.service;

import com.ssafy.enjoytrip.dto.AttractionInfo;

import java.util.List;

public interface AttractionInfoService {
    List<AttractionInfo> selectAll();

    List<AttractionInfo> selectTop4();

    List<AttractionInfo> selectByTitle(String search_title);

    List<AttractionInfo> selectBySidoCode(String sidoCode, int currentPage, int perPage);
    Integer selectBySidoCodeCount(String sidoCode);

    AttractionInfo selectByContentID(String contentId);

    List<AttractionInfo> userFavoriteList();

    void likeCountUp(String contentId, String name);

    void likeCountDown(String contentId);

}
