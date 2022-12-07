package com.classylab.youtubeapi.youtube.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Genre {
    왁킹, 비보잉;

    public static Genre nameOf(String name) {
        for (Genre genre : Genre.values()) {
            if (genre.name().equals(name)) {
                return genre;
            }
        }
        return null;
    }
}