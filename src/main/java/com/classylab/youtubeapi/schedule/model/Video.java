package com.classylab.youtubeapi.schedule.model;

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

    @Id
    @Column(name = "VIDEO_ID")
    private String videoId;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String title;

    private LocalDateTime publishedAt;

    @OneToMany(mappedBy = "dance", cascade = CascadeType.PERSIST)
    private List<Thumbnail> thumbnails = new ArrayList<>();

    public void addThumbnails(Thumbnail thumbnail) {
        this.thumbnails.add(thumbnail);
        if (thumbnail.getDance() != this) {
            thumbnail.setDance(this);
        }
    }

    public static Video create(Genre genre, String title, String videoId, String publishedAt) {
        Video video = new Video();
        video.genre = genre;
        video.title = title;
        video.videoId = videoId;
        video.publishedAt = stringToLocalDateTime(publishedAt);
        return video;
    }
    private static LocalDateTime stringToLocalDateTime(String dateTime) {
        return dateTime.charAt(dateTime.length() - 1) == 'Z' ? LocalDateTime.parse(dateTime) : LocalDateTime.parse(dateTime.substring(0, dateTime.length() - 1));
    }
}
