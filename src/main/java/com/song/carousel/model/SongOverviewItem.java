package com.song.carousel.model;

public class SongOverviewItem {
    private final String id;
    private final String title;

    public SongOverviewItem(String id, String title) {
        this.id = id;
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}