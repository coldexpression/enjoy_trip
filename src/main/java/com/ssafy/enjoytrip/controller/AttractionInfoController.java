package com.ssafy.enjoytrip.controller;

import com.ssafy.enjoytrip.dto.AttractionInfo;
import com.ssafy.enjoytrip.model.service.AttractionInfoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(originPatterns = {"http://localhost:8080", "http://127.0.0.1:8080"})
@RequestMapping("/attraction")
public class AttractionInfoController {

    private final AttractionInfoServiceImpl attractionInfoService;

    @GetMapping("/list")
    public ResponseEntity<List<AttractionInfo>> selectAll() {
        return new ResponseEntity<>(attractionInfoService.selectAll(), HttpStatus.OK);
    }

    @GetMapping("/top4")
    public ResponseEntity<List<AttractionInfo>> selectTop4() {
        return new ResponseEntity<>(attractionInfoService.selectTop4(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AttractionInfo>> selectByTitle(@RequestParam String search_title) {
        System.out.println(search_title);
        return new ResponseEntity<>(attractionInfoService.selectByTitle(search_title), HttpStatus.OK);
    }

    @GetMapping("/list/{sido_code}")
    public ResponseEntity<List<AttractionInfo>> selectBySidoCode(@PathVariable String sido_code) {
        System.out.println(sido_code);
        return new ResponseEntity<>(attractionInfoService.selectBySidoCode(sido_code), HttpStatus.OK);
    }

    @GetMapping("/{content_id}")
    public ResponseEntity<AttractionInfo> selectByContentID(@PathVariable String content_id) {
        return new ResponseEntity<>(attractionInfoService.selectByContentID(content_id), HttpStatus.OK);
    }

    @GetMapping("/userFavorite")
    public ResponseEntity<List<AttractionInfo>> userFavoriteList(@RequestParam String user_id) {
        return new ResponseEntity<>(attractionInfoService.userFavoriteList(user_id), HttpStatus.OK);
    }


    @PostMapping("/{content_id}/likeUp")
    public ResponseEntity<?> likeCountUp(@PathVariable String content_id, @RequestParam String user_id, @RequestParam String name){
        attractionInfoService.likeCountUp(content_id, user_id, name );
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/{content_id}/likeDown")
    public ResponseEntity<?> likeCountDown(@PathVariable String content_id, @RequestParam String user_id){
        attractionInfoService.likeCountDown(content_id, user_id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
