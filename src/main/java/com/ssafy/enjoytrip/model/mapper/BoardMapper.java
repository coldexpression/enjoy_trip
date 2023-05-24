package com.ssafy.enjoytrip.model.mapper;

import com.ssafy.enjoytrip.dto.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {
    List<Board> selectAll();

    List<Board> selectByTitle(String search_title);

    List<Board> selectByUserID(String userID);

    void readCountUp(Integer num);

    boolean BoardInsert(Board boardInfo);

    boolean BoardDelete(int num);
    Board selectByNum(int num);
}
