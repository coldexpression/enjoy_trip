package com.ssafy.enjoytrip.model.service;

import com.ssafy.enjoytrip.dto.User;

public interface UserService {
    User login(User user);

    boolean signUp(User user);

    User check(User user);

    boolean update(User user);

    boolean delete(User user);
}
