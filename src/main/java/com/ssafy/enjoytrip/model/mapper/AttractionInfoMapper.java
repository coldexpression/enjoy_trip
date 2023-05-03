package com.ssafy.enjoytrip.model.mapper;

import com.ssafy.enjoytrip.dto.AttractionInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttractionInfoMapper {
    List<AttractionInfo> selectAll();

    List<AttractionInfo> selectTop4();

    List<AttractionInfo> selectByTitle(String searchTitle);

    AttractionInfo selectByContentID(String contentId);

    void readCountUp(String contentId);

    void likeCountUp(String contentId);

    void likeCountDown(String contentId);
    void favoriteInsert(Map<String, String> favoriteInfo);

    void favoriteDelete(Map<String, String> favoriteInfo);
}
