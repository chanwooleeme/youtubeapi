package com.classylab.youtubeapi.youtube.schedule;

import com.classylab.youtubeapi.youtube.service.YoutubeService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Scheduler {
    private static final String fireEveryFiveHour = "0 0 0/5 * * *";
    private final YoutubeService youtubeFeignService;

    @Scheduled(cron = fireEveryFiveHour)
    public void scheduleTaskUsingCronExpression() {
        youtubeFeignService.saveYoutubeData();
    }
}
