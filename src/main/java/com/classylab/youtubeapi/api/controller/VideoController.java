package com.classylab.youtubeapi.api.controller;

import com.classylab.youtubeapi.api.model.VideoListResponse;
import com.classylab.youtubeapi.api.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @GetMapping("/api/v1/video")
    public ResponseEntity<VideoListResponse> response(@RequestParam String genres, Pageable pageable) {
        VideoListResponse response = videoService.findVideosByGenres(genres, pageable);
        return ResponseEntity.ok(response);
    }

}
