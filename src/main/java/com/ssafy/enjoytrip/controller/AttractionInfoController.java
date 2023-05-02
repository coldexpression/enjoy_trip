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
@CrossOrigin(originPatterns = {"http://localhost:5500", "http://127.0.0.1:5500"})
@RequestMapping("/attraction")
public class AttractionInfoController {

    private final AttractionInfoServiceImpl attractionInfoService;

    @GetMapping("/list")
    public ResponseEntity<List<AttractionInfo>> selectAll() {
        return new ResponseEntity<>(attractionInfoService.selectAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<AttractionInfo>> selectByTitle(@RequestParam String searchTitle) {
        return new ResponseEntity<>(attractionInfoService.selectByTitle(searchTitle), HttpStatus.OK);
    }

    @GetMapping("/{contentId}")
    public ResponseEntity<AttractionInfo> selectByContentID(@PathVariable String contentId) {
        return new ResponseEntity<>(attractionInfoService.selectByContentID(contentId), HttpStatus.OK);
    }

    @PostMapping("/{contentId}/likeUp")
    public ResponseEntity<?> likeCountUp(@PathVariable String contentId){
        attractionInfoService.likeCountUp(contentId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
