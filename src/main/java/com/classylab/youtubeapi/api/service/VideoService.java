package com.classylab.youtubeapi.api.service;

import com.classylab.youtubeapi.api.model.VideoListResponse;
import com.classylab.youtubeapi.schedule.model.Genre;
import com.classylab.youtubeapi.schedule.model.Video;
import com.classylab.youtubeapi.schedule.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final VideoRepository videoRepository;

    @Transactional(readOnly = true)
    public List<Video> findByGenre(Genre genre, Pageable pageable) {
        return videoRepository.findAllByGenre(genre, pageable);
    }

    public VideoListResponse responseVideoList(Genre genre, Pageable pageable) {
        return VideoListResponse.create(findByGenre(genre, pageable));
    }
}
