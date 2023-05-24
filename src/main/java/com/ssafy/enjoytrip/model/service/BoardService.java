package com.ssafy.enjoytrip.model.service;

import com.ssafy.enjoytrip.dto.Board;

import java.util.List;
import java.util.Map;

public interface BoardService {
    List<Board> selectAll();

    List<Board> selectByTitle(String search_title);

    List<Board> selectByUserID(String userID);

    Board selectByNum(int num);

    boolean BoardInsert(Board boardInfo);
    boolean BoardDelete(int num);

}
