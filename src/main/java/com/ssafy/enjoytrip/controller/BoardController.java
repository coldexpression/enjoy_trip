package com.ssafy.enjoytrip.controller;

import com.ssafy.enjoytrip.dto.Board;
import com.ssafy.enjoytrip.model.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/board")
public class BoardController {

    private final BoardServiceImpl boardService;

    @GetMapping("/list")
    public ResponseEntity<List<Board>> selectAll() {
        return new ResponseEntity<>(boardService.selectAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Board>> selectByTitle(@RequestParam String searchTitle) {
        System.out.println(searchTitle);
        return new ResponseEntity<>(boardService.selectByTitle(searchTitle), HttpStatus.OK);
    }


    @GetMapping("/{userID}")
    public ResponseEntity<List<Board>> selectByUserID(@PathVariable String userID) {
        System.out.println(userID);
        return new ResponseEntity<>(boardService.selectByUserID(userID), HttpStatus.OK);
    }

    @PostMapping({"/regist"})
    public ResponseEntity<Boolean> BoardInsert(@RequestBody Board board){
        return new ResponseEntity<>(boardService.BoardInsert(board), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Boolean> BoardDelete(@RequestParam int num){
        System.out.println(num);
        return new ResponseEntity<>(boardService.BoardDelete(num),HttpStatus.OK);
    }


}
