package com.ssafy.enjoytrip.model.mapper;

import com.ssafy.enjoytrip.dto.AttractionInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttractionInfoMapper {
    List<AttractionInfo> selectAll();

    List<AttractionInfo> selectTop4();

    List<AttractionInfo> selectByTitle(String searchTitle);

    AttractionInfo selectByContentID(String contentId);

    void likeCountUp(String contentID);
}
