package com.ssafy.enjoytrip.model.service;

import com.ssafy.enjoytrip.dto.Board;
import com.ssafy.enjoytrip.model.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;


    @Override
    public List<Board> selectAll() {
        return boardMapper.selectAll();
    }

    @Override
    public List<Board> selectByTitle(String search_title) {
        return boardMapper.selectByTitle(search_title);
    }

    @Override
    public List<Board> selectByUserID(String userID) {
        return boardMapper.selectByUserID(userID);
    }

    @Override
    public Board selectByNum(int num){
        boardMapper.readCountUp(num);
        return boardMapper.selectByNum(num);
    }

    public boolean BoardInsert(Board boardInfo){
        return boardMapper.BoardInsert(boardInfo);
    }
    public boolean BoardDelete(int num){
        return boardMapper.BoardDelete(num);
    }
}
