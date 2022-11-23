package com.classylab.youtubeapi.schedule.repository;

import com.classylab.youtubeapi.schedule.model.Thumbnail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThumbnailRepository extends JpaRepository<Thumbnail, Long> {
}
