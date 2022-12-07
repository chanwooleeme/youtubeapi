package com.classylab.youtubeapi.api.model;

import com.classylab.youtubeapi.youtube.model.Video;
import lombok.Getter;

@Getter
public class VideoResponse {

    private String videoId;

    private String genre;

    private String title;

    private String channelTitle;

    private String publishedAt;

    private ThumbnailResponse thumbnails;

    public static VideoResponse from(Video video) {
        VideoResponse response = new VideoResponse();
        response.videoId = video.getVideoId();
        response.genre = video.getGenre().toString();
        response.title = video.getTitle();
        response.channelTitle = video.getChannelTitle();
        response.publishedAt = video.getPublishedAt().toString();
        response.thumbnails = ThumbnailResponse.from(video.getThumbnails());
        return response;
    }
}
