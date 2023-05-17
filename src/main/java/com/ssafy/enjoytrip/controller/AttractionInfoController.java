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
    public ResponseEntity<List<AttractionInfo>> selectByTitle(@RequestParam String searchTitle) {
        System.out.println(searchTitle);
        return new ResponseEntity<>(attractionInfoService.selectByTitle(searchTitle), HttpStatus.OK);
    }

    @GetMapping("/list/{sidoCode}")
    public ResponseEntity<List<AttractionInfo>> selectBySidoCode(@PathVariable String sidoCode) {
        System.out.println(sidoCode);
        return new ResponseEntity<>(attractionInfoService.selectBySidoCode(sidoCode), HttpStatus.OK);
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<AttractionInfo> selectByContentID(@PathVariable String contentId) {
        return new ResponseEntity<>(attractionInfoService.selectByContentID(contentId), HttpStatus.OK);
    }

    @GetMapping("/userFavorite")
    public ResponseEntity<List<AttractionInfo>> userFavoriteList(@RequestParam String userId) {
        return new ResponseEntity<>(attractionInfoService.userFavoriteList(userId), HttpStatus.OK);
    }


    @PostMapping("/{contentId}/likeUp")
    public ResponseEntity<?> likeCountUp(@PathVariable String contentId, @RequestParam String userId, @RequestParam String name){
        attractionInfoService.likeCountUp(contentId, userId, name );
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/{contentId}/likeDown")
    public ResponseEntity<?> likeCountDown(@PathVariable String contentId, @RequestParam String userId){
        attractionInfoService.likeCountDown(contentId, userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
