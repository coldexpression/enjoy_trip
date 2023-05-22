package com.ssafy.enjoytrip.model.mapper;

import com.ssafy.enjoytrip.dto.AttractionInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttractionInfoMapper {
    List<AttractionInfo> selectAll();

    List<AttractionInfo> selectAllB();

    List<AttractionInfo> selectTop4();

    List<AttractionInfo> selectByTitle(String searchTitle);

    List<AttractionInfo> selectBySidoCode(String sidoCode);

    AttractionInfo selectByContentID(String contentId);

    void readCountUp(String contentId);

    List<AttractionInfo> userFavoriteList(String userId);

    void likeCountUp(String contentId);

    void likeCountDown(String contentId);
    void favoriteInsert(Map<String, String> favoriteInfo);

    void favoriteDelete(Map<String, String> favoriteInfo);
}
