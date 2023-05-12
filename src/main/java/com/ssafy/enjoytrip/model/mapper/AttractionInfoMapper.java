package com.ssafy.enjoytrip.model.mapper;

import com.ssafy.enjoytrip.dto.AttractionInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AttractionInfoMapper {
    List<AttractionInfo> selectAll();

    List<AttractionInfo> selectTop4();

    List<AttractionInfo> selectByTitle(String search_title);

    List<AttractionInfo> selectBySidoCode(String sido_code);

    AttractionInfo selectByContentID(String content_id);

    void readCountUp(String content_id);

    List<AttractionInfo> userFavoriteList(String user_id);

    void likeCountUp(String content_id);

    void likeCountDown(String content_id);
    void favoriteInsert(Map<String, String> favoriteInfo);

    void favoriteDelete(Map<String, String> favoriteInfo);
}
