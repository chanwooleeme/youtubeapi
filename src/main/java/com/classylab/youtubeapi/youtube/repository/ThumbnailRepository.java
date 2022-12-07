package com.classylab.youtubeapi.youtube.repository;

import com.classylab.youtubeapi.youtube.model.Thumbnail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThumbnailRepository extends JpaRepository<Thumbnail, Long> {
}
