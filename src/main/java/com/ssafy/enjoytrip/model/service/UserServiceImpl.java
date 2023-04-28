package com.ssafy.enjoytrip.model.service;

import com.ssafy.enjoytrip.dto.User;
import com.ssafy.enjoytrip.model.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    @Override
    public boolean signUp(User user) {
        return userMapper.signUp(user) != 0;
    }

    @Override
    public User check(User user) {
        return userMapper.check(user);
    }

    @Override
    public boolean update(User user) {
        return userMapper.update(user) != 0;
    }

    @Override
    public boolean delete(User user) {
        return userMapper.delete(user) != 0;
    }
}
