package com.classylab.youtubeapi.batch.service;

import com.classylab.youtubeapi.batch.client.YoutubeClient;
import com.classylab.youtubeapi.batch.client.model.YoutubeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class YoutubeFeignService {

    private final YoutubeClient youtubeClient;

    public YoutubeResponse getYoutubeResposeByKeyword(String keyword) {
        return youtubeClient.getSearchResponse(keyword);
    }
}
