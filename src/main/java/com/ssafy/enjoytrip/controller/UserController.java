package com.ssafy.enjoytrip.controller;

import com.ssafy.enjoytrip.dto.User;
import com.ssafy.enjoytrip.model.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = {"http://localhost:8080", "http://127.0.0.1:8080"})
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User resultUser = userService.login(user);
        if (resultUser == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(resultUser, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Boolean> signUp(@RequestBody User user) {
        return new ResponseEntity<>(userService.signUp(user), HttpStatus.OK);
    }

    @PostMapping("/check")
    public ResponseEntity<User> check(@RequestBody User user) {
        return new ResponseEntity<>(userService.check(user), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Boolean> update(@RequestBody User user) {
        boolean result = userService.update(user);
        if (!result) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(@RequestBody User user) {
        return new ResponseEntity<>(userService.delete(user), HttpStatus.OK);
    }
}
