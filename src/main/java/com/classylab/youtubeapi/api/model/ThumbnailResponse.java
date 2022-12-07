package com.classylab.youtubeapi.api.model;

import com.classylab.youtubeapi.youtube.client.model.YoutubeResponse;
import com.classylab.youtubeapi.youtube.model.Thumbnail;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class ThumbnailResponse {

    @JsonProperty("default")
    private YoutubeResponse.Quality defaultQuality;

    @JsonProperty("medium")
    private YoutubeResponse.Quality mediumQuality;

    @JsonProperty("high")
    private YoutubeResponse.Quality highQuality;

    public static ThumbnailResponse from(List<Thumbnail> thumbnails) {
        ThumbnailResponse response = new ThumbnailResponse();
        for (Thumbnail thumbnail : thumbnails) {
            if ("Default".equals(thumbnail.getQuality()))
                response.defaultQuality = YoutubeResponse.Quality.create(thumbnail);
            else if("Medium".equals(thumbnail.getQuality()))
                response.mediumQuality = YoutubeResponse.Quality.create(thumbnail);
            else
                response.highQuality = YoutubeResponse.Quality.create(thumbnail);
        }
        return response;
    }
}
