package com.classylab.youtubeapi.batch.client.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class YoutubeResponse {
    private String kind;
    private String etag;
    private String nextPageToken;
    private String regionCode;
    private PageInfo pageInfo;
    private ArrayList<Item> items;

    @Getter
    static class PageInfo {
        private Long totalResults;
        private Long resultsPerPage;
    }

    @Getter
    static class Item {
        private String kind;
        private String etag;
        private Id id;
        private Snippet snippet;
    }
    @Getter
    static class Id {
        private String kind;
        private String videoId;
    }

    @Getter
    static class Snippet {
        private String publishedAt;
        private String channelId;
        private String title;
        private String description;
        private Thumbnails thumbnails;
        private String channelTitle;
        private String liveBroadcastContent;
        private String publishTime;
    }

    @Getter
    static class Thumbnails {
        @JsonProperty("default")
        private Default aDefault;
        private Medium medium;
        private High high;
    }

    @Getter
    static class Default {
        private String url;
        private String width;
        private String height;
    }

    @Getter
    static class Medium {
        private String url;
        private String width;
        private String height;
    }

    @Getter
    static class High {
        private String url;
        private String width;
        private String height;
    }
}
