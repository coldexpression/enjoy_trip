package com.ssafy.enjoytrip.model.mapper;

import com.ssafy.enjoytrip.dto.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataIntegrityViolationException;

@Mapper
public interface UserMapper {
    User login(User user);

    Integer signUp(User user) throws DataIntegrityViolationException;

    User check(User user);

    Integer update(User user);

    Integer delete(User user);

    User findUserById(String id);
}
