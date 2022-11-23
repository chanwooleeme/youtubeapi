package com.classylab.youtubeapi.schedule.repository;

import com.classylab.youtubeapi.schedule.model.Dance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanceRepository extends JpaRepository<Dance, Long> {
}
