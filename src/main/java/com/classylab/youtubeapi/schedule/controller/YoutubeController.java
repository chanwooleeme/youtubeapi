package com.classylab.youtubeapi.schedule.controller;

import com.classylab.youtubeapi.schedule.client.model.YoutubeResponse;
import com.classylab.youtubeapi.schedule.service.YoutubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class YoutubeController {
    private final YoutubeService youtubeFeignService;

    @GetMapping("/{keyword}")
    public ResponseEntity<YoutubeResponse> getYoutubeResponseBy(@PathVariable String keyword) {
        return ResponseEntity.ok(youtubeFeignService.getYoutubeResposeByKeyword(keyword));
    }
}
