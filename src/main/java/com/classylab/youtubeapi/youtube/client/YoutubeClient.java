package com.classylab.youtubeapi.youtube.client;

import com.classylab.youtubeapi.youtube.client.model.YoutubeResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name ="YoutubeClient", url = "${youtube.api.url}")
public interface YoutubeClient {

    @GetMapping("${youtube.api.search}")
    YoutubeResponse getSearchResponse(@RequestParam(value = "q") String q, @RequestParam(value = "pageToken", required = false) String pageToken);
}
