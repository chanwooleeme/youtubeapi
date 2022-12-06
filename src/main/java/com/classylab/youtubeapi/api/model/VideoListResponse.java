package com.classylab.youtubeapi.api.model;

import com.classylab.youtubeapi.schedule.model.Video;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class VideoListResponse {
    private List<VideoResponse> videos;

    public static VideoListResponse create(List<Video> videos) {
        VideoListResponse videoListResponse = new VideoListResponse();
        videoListResponse.videos = videos.stream().map(VideoResponse::from).collect(Collectors.toList());;
        return videoListResponse;
    }
}
