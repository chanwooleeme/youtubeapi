package com.classylab.youtubeapi.schedule.repository;

import com.classylab.youtubeapi.schedule.model.Video;
import com.classylab.youtubeapi.schedule.model.Genre;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findAllByGenre(Genre genre, Pageable pageable);

    List<Video> findAllByGenreIn(List<Genre> genres, Pageable pageable);

    Video findByVideoId(String videoId);

    boolean existsDanceByVideoId(String videoId);
}
