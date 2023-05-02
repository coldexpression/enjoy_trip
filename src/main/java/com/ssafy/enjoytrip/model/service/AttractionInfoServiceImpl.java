package com.ssafy.enjoytrip.model.service;

import com.ssafy.enjoytrip.dto.AttractionInfo;
import com.ssafy.enjoytrip.model.mapper.AttractionInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return attractionInfoMapper.selectByContentID(contentId);
    }

    @Override
    public void likeCountUp(String contentId) {
        attractionInfoMapper.likeCountUp(contentId);
    }
}
