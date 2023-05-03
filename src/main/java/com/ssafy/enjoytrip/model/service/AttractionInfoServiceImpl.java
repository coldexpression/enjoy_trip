package com.ssafy.enjoytrip.model.service;

import com.ssafy.enjoytrip.dto.AttractionInfo;
import com.ssafy.enjoytrip.model.mapper.AttractionInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AttractionInfoServiceImpl implements AttractionInfoService {

    private final AttractionInfoMapper attractionInfoMapper;


    @Override
    public List<AttractionInfo> selectAll() {
        return attractionInfoMapper.selectAll();
    }

    public List<AttractionInfo> selectTop4()  {
        return attractionInfoMapper.selectTop4();
    }

    @Override
    public List<AttractionInfo> selectByTitle(String searchTitle) {
        return attractionInfoMapper.selectByTitle(searchTitle);
    }

    @Override
    public AttractionInfo selectByContentID(String contentId) {
        attractionInfoMapper.readCountUp(contentId);
        return attractionInfoMapper.selectByContentID(contentId);
    }

    @Override
    public List<AttractionInfo> userFavoriteList(String user_id){
        return attractionInfoMapper.userFavoriteList(user_id);
    }

    @Override
    public void likeCountUp(String contentId, String user_id, String name) {
        attractionInfoMapper.likeCountUp(contentId);
        Map<String, String> favoriteInfo = new HashMap<String, String>();
        favoriteInfo.put("contentId", contentId);
        favoriteInfo.put("user_id", user_id);
        favoriteInfo.put("name", name);
        attractionInfoMapper.favoriteInsert(favoriteInfo);
    }
    @Override
    public void likeCountDown(String contentId, String user_id) {
        attractionInfoMapper.likeCountDown(contentId);
        Map<String, String> favoriteInfo = new HashMap<String, String>();
        favoriteInfo.put("contentId", contentId);
        favoriteInfo.put("user_id", user_id);
        attractionInfoMapper.favoriteDelete(favoriteInfo);
    }
}
