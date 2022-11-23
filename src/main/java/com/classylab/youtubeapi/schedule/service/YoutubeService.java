package com.classylab.youtubeapi.schedule.service;

import com.classylab.youtubeapi.schedule.client.YoutubeClient;
import com.classylab.youtubeapi.schedule.client.model.YoutubeResponse;
import com.classylab.youtubeapi.schedule.model.Dance;
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

    @Transactional
    public void saveYoutubeData() {
        for(Genre genre : Genre.values()) {
            YoutubeResponse response = getYoutubeResposeByKeyword(genre.name());
            convertAndSaveYoutubeResponse(response, genre);
        }
    }

    public YoutubeResponse getYoutubeResposeByKeyword(String keyword) {
        return youtubeClient.getSearchResponse(keyword);
    }

    private void convertAndSaveYoutubeResponse(YoutubeResponse youtubeResponse, Genre genre) {
        for (YoutubeResponse.Item item  : youtubeResponse.getItems()) {
            Dance dance = Dance.create(genre, item.getTitle(), item.getId());
            Map<String, YoutubeResponse.Quality> qualities = item.getThumbnailQualities();
            for (String key: qualities.keySet()) {
                YoutubeResponse.Quality quality = qualities.get(key);
                Thumbnail thumbnail = Thumbnail.create(key, quality.getUrl(), quality.getWidth(), quality.getHeight());
                thumbnail.setDance(dance);
                thumbnailRepository.save(thumbnail);
                dance.addThumbnails(thumbnail);
            }
            danceRepository.save(dance);
        }
    }
}
