package com.classylab.youtubeapi.schedule.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Thumbnail {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THUMBNAIL_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "DANCE_ID")
    private Dance dance;

    private String quality;

    private String url;

    private String width;

    private String height;

    public static Thumbnail create(String quality, String url, String width, String height) {
        Thumbnail thumbnail = new Thumbnail();
        thumbnail.quality = quality;
        thumbnail.url = url;
        thumbnail.width = width;
        thumbnail.height = height;
        return thumbnail;
    }

    public void setDance(Dance dance) {
        if (this.dance != null) {
            this.dance.getThumbnails().remove(this);
        }
        this.dance = dance;
        dance.getThumbnails().add(this);
    }
}
