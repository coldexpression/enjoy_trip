package com.ssafy.enjoytrip.model.service;

import com.ssafy.enjoytrip.dto.AttractionInfo;
import com.ssafy.enjoytrip.dto.User;
import com.ssafy.enjoytrip.model.mapper.AttractionInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
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
    public List<AttractionInfo> selectBySidoCode(String sido_code) {
        return attractionInfoMapper.selectBySidoCode(sido_code);
    }

    @Override
    public AttractionInfo selectByContentID(String content_id) {
        attractionInfoMapper.readCountUp(content_id);
        return attractionInfoMapper.selectByContentID(content_id);
    }

    @Override
    public List<AttractionInfo> userFavoriteList(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userInfo = (User)principal;
        String userId = userInfo.getId();
        return attractionInfoMapper.userFavoriteList(userId);
    }

    @Override
    public void likeCountUp(String contentId, String name) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userInfo = (User)principal;
        String userId = userInfo.getId();

        log.debug("현재 유저 정보 : {}", userId);
        attractionInfoMapper.likeCountUp(contentId);
        Map<String, String> favorite_info = new HashMap<String, String>();
        favorite_info.put("contentId", contentId);
        favorite_info.put("userId", userId);
        favorite_info.put("name", name);
        attractionInfoMapper.favoriteInsert(favorite_info);
    }
    @Override
    public void likeCountDown(String contentId) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userInfo = (User)principal;
        String userId = userInfo.getId();

        attractionInfoMapper.likeCountDown(contentId);
        Map<String, String> favorite_info = new HashMap<String, String>();
        favorite_info.put("contentId", contentId);
        favorite_info.put("userId", userId);
        attractionInfoMapper.favoriteDelete(favorite_info);
    }
}
