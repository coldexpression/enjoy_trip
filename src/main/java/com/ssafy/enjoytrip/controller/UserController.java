package com.ssafy.enjoytrip.controller;

import com.ssafy.enjoytrip.dto.User;
import com.ssafy.enjoytrip.model.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
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
    public ResponseEntity<Boolean> update(User user) {
        return new ResponseEntity<>(userService.update(user), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Boolean> delete(User user) {
        return new ResponseEntity<>(userService.delete(user), HttpStatus.OK);
    }
}
