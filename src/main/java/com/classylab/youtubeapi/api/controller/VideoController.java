package com.classylab.youtubeapi.api.controller;

import com.classylab.youtubeapi.api.model.VideoListResponse;
import com.classylab.youtubeapi.api.model.VideoResponse;
import com.classylab.youtubeapi.api.service.VideoService;
import com.classylab.youtubeapi.schedule.model.Genre;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VideoController {

    private final VideoService videoService;

    @GetMapping("/api/v1/video/{genre}")
    public ResponseEntity<VideoListResponse> response(@PathVariable Genre genre, Pageable pageable) {
        VideoListResponse response = videoService.responseVideoList(genre, pageable);
        return ResponseEntity.ok(response);
    }

}
