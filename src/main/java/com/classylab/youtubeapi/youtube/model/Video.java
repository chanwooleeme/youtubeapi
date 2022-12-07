package com.classylab.youtubeapi.youtube.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Video {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "VIDEO_ID", unique = true)
    private String videoId;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String title;

    private String channelTitle;

    private LocalDateTime publishedAt;

    private Long relevance;

    @OneToMany(mappedBy = "video", fetch = FetchType.LAZY)
    private List<Thumbnail> thumbnails = new ArrayList<>();

    public static Video create(Genre genre, String title, String channelTitle, String videoId, String publishedAt, Long relevance) {
        Video video = new Video();
        video.genre = genre;
        video.title = title;
        video.channelTitle = channelTitle;
        video.videoId = videoId;
        video.publishedAt = stringToLocalDateTime(publishedAt);
        video.relevance = relevance;
        return video;
    }
    private static LocalDateTime stringToLocalDateTime(String dateTime) {
        return dateTime.charAt(dateTime.length() - 1) == 'Z' ? LocalDateTime.parse(dateTime.substring(0, dateTime.length() - 1)) : LocalDateTime.parse(dateTime);
    }
}
