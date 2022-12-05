package com.classylab.youtubeapi.schedule.service;

import com.classylab.youtubeapi.schedule.client.YoutubeClient;
import com.classylab.youtubeapi.schedule.client.model.YoutubeResponse;
import com.classylab.youtubeapi.schedule.model.Video;
import com.classylab.youtubeapi.schedule.model.Genre;
import com.classylab.youtubeapi.schedule.model.Thumbnail;
import com.classylab.youtubeapi.schedule.repository.DanceRepository;
import com.classylab.youtubeapi.schedule.repository.ThumbnailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class YoutubeService {

    private final YoutubeClient youtubeClient;
    private final DanceRepository danceRepository;
    private final ThumbnailRepository thumbnailRepository;

    private final int MAX_PAGE = 10;

    public void saveYoutubeData() {
        for(Genre genre : Genre.values()) {
            getYoutubeResponseByKeyword(genre.name());
        }
    }

    @Transactional
    public void getYoutubeResponseByKeyword(String keyword) {
        String pageToken = "";
        int page = 0;

        while(page < MAX_PAGE) {
            YoutubeResponse response = youtubeClient.getSearchResponse(keyword, pageToken);
            if (response.getNextPageToken() == null) break;
            pageToken = response.getNextPageToken();
            saveYoutubeResponse(response, Genre.nameOf(keyword));
            page += 1;
        }
    }

    private void saveYoutubeResponse(YoutubeResponse youtubeResponse, Genre genre) {
        for (YoutubeResponse.Item item  : youtubeResponse.getItems()) {
            if (danceRepository.existsDanceByVideoId(item.getVideoId())) continue;

            Video dance = Video.create(genre, item.getTitle(), item.getVideoId(), item.getPublishedAt());
            dance = danceRepository.save(dance);

            Map<String, YoutubeResponse.Quality> qualities = item.getThumbnailQualities();

            for (String key:qualities.keySet()) {
                YoutubeResponse.Quality quality = qualities.get(key);
                Thumbnail thumbnail = Thumbnail.create(key, quality.getUrl(), quality.getWidth(), quality.getHeight());
                dance.addThumbnails(thumbnail);
                thumbnailRepository.save(thumbnail);
            }
        }
    }
}
