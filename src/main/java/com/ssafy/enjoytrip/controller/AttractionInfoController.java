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

    @GetMapping("/list/{sidoCode}/count")
    public ResponseEntity<Integer> selectBySidoCodeCount(@PathVariable String sidoCode) {
        System.out.println(sidoCode);
        return new ResponseEntity<>(attractionInfoService.selectBySidoCodeCount(sidoCode), HttpStatus.OK);
    }

    @GetMapping("/list/{sidoCode}")
    public ResponseEntity<List<AttractionInfo>> selectBySidoCode(@PathVariable(name = "sidoCode") String sidoCode,
                                                                 @RequestParam(defaultValue = "0", name = "currentPage") int currentPage,
                                                                 @RequestParam(defaultValue = "999", name="perPage") int perPage) {
        return new ResponseEntity<>(attractionInfoService.selectBySidoCode(sidoCode, currentPage, perPage), HttpStatus.OK);
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<AttractionInfo> selectByContentID(@PathVariable String contentId) {
        return new ResponseEntity<>(attractionInfoService.selectByContentID(contentId), HttpStatus.OK);
    }

    @GetMapping("/userFavorite")
    public ResponseEntity<List<AttractionInfo>> userFavoriteList() {
        return new ResponseEntity<>(attractionInfoService.userFavoriteList(), HttpStatus.OK);
    }


    @PostMapping("/{contentId}/likeUp")
    public ResponseEntity<?> likeCountUp(@PathVariable String contentId, @RequestParam(required = false) String name){
        attractionInfoService.likeCountUp(contentId, name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/{contentId}/likeDown")
    public ResponseEntity<?> likeCountDown(@PathVariable String contentId){
        attractionInfoService.likeCountDown(contentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
