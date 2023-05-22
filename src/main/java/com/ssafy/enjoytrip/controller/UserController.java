package com.ssafy.enjoytrip.controller;

import com.ssafy.enjoytrip.dto.User;
import com.ssafy.enjoytrip.model.service.UserServiceImpl;
import com.ssafy.enjoytrip.util.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = {"http://localhost:8080", "http://127.0.0.1:8080"})
@RequestMapping("/user")
@Slf4j
public class UserController {

    private final UserServiceImpl userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User resultUser = userService.login(user);
        if (resultUser == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        log.debug("입력 비밀번호 : {}", user.getPassword());
        log.debug("DB 비밀번호 : {}", resultUser.getPassword());
        if (!passwordEncoder.matches(user.getPassword(), resultUser.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호 입니다.");
        }
        String token = jwtTokenProvider.createToken(resultUser.getId(), "User");
        HttpHeaders headers = new HttpHeaders();
        resultUser.setAccessToken(token);
        headers.add("Authorization", token);
        return new ResponseEntity<>(resultUser, headers, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signUp(@RequestBody User user) {
        user.setPwd(passwordEncoder.encode(user.getPassword()));
        try {
            userService.signUp(user);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
//        return new ResponseEntity<>(userService.signUp(user), HttpStatus.OK);
    }

    @PostMapping("/check")
    public ResponseEntity<User> check(@RequestBody User user) {
        return new ResponseEntity<>(userService.check(user), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody User user) {
        User resultUser = userService.login(user);
        if (resultUser == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        if (!passwordEncoder.matches(user.getPassword(), resultUser.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호 입니다.");
        }


        user.setNewPwd(passwordEncoder.encode(user.getNewPwd()));
        boolean result = userService.update(user);
        if (!result) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boolean> delete(@RequestBody User user) {
        User resultUser = userService.login(user);
        if (resultUser == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        log.debug("입력 비밀번호 : {}", user.getPassword());
        log.debug("DB 비밀번호 : {}", resultUser.getPassword());
        if (!passwordEncoder.matches(user.getPassword(), resultUser.getPassword()))
            throw new IllegalArgumentException("잘못된 비밀번호 입니다.");
        return new ResponseEntity<>(userService.delete(user), HttpStatus.OK);
    }
}
