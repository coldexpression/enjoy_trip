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
    public List<AttractionInfo> selectByTitle(String search_title) {
        return attractionInfoMapper.selectByTitle(search_title);
    }

    @Override
    public List<AttractionInfo> selectBySidoCode(String sido_code) {
        return attractionInfoMapper.selectBySidoCode(sido_code);
    }

    @Override
    public AttractionInfo selectByContentID(String content_id) {
        attractionInfoMapper.readCountUp(content_id);
        return attractionInfoMapper.selectByContentID(content_id);
    }

    @Override
    public List<AttractionInfo> userFavoriteList(String user_id){
        return attractionInfoMapper.userFavoriteList(user_id);
    }

    @Override
    public void likeCountUp(String content_id, String user_id, String name) {
        attractionInfoMapper.likeCountUp(content_id);
        Map<String, String> favorite_info = new HashMap<String, String>();
        favorite_info.put("content_id", content_id);
        favorite_info.put("user_id", user_id);
        favorite_info.put("name", name);
        attractionInfoMapper.favoriteInsert(favorite_info);
    }
    @Override
    public void likeCountDown(String content_id, String user_id) {
        attractionInfoMapper.likeCountDown(content_id);
        Map<String, String> favorite_info = new HashMap<String, String>();
        favorite_info.put("content_id", content_id);
        favorite_info.put("user_id", user_id);
        attractionInfoMapper.favoriteDelete(favorite_info);
    }
}
