package com.classylab.youtubeapi.schedule.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Dance {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DANCE_ID")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private String title;

    private String videoId;

    @OneToMany(mappedBy = "dance")
    private List<Thumbnail> thumbnails = new ArrayList<>();

    public void addThumbnails(Thumbnail thumbnail) {
        this.thumbnails.add(thumbnail);
        if (thumbnail.getDance() != this) {
            thumbnail.setDance(this);
        }
    }

    public static Dance create(Genre genre, String title, String videoId) {
        Dance dance = new Dance();
        dance.genre = genre;
        dance.title = title;
        dance.videoId = videoId;
        return dance;
    }
}
