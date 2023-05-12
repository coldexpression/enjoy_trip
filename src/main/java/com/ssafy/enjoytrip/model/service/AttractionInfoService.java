package com.ssafy.enjoytrip.model.service;

import com.ssafy.enjoytrip.dto.AttractionInfo;

import java.util.List;

public interface AttractionInfoService {
    List<AttractionInfo> selectAll();

    List<AttractionInfo> selectTop4();

    List<AttractionInfo> selectByTitle(String search_title);

    List<AttractionInfo> selectBySidoCode(String sido_code);

    AttractionInfo selectByContentID(String content_id);

    List<AttractionInfo> userFavoriteList(String user_id);

    void likeCountUp(String content_id, String user_id, String name);

    void likeCountDown(String content_id, String user_id);

}
