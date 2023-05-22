package com.ssafy.enjoytrip.model.service;

import com.ssafy.enjoytrip.dto.ResponseLogin;
import com.ssafy.enjoytrip.dto.User;
import com.ssafy.enjoytrip.model.mapper.UserMapper;
import com.ssafy.enjoytrip.util.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserMapper userMapper;


    @Override
    public User login(User user) {
        return userMapper.findUserById(user.getId());
    }

    @Override
    public boolean signUp(User user) throws DataIntegrityViolationException {
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

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return userMapper.findUserById(userName);
    }
}
