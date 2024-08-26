package com.song.carousel.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "songs")
public class Song {

    @Id
    private String id;

    @Field(name = "title")
    private String title;

    @Field(name = "image")
    private Image image;

    @Field(name = "lyrics")
    private String lyrics;

    @Field(name = "youTube")
    private String youTube;

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }

    public String getYouTube() {
        return youTube;
    }

    public void setYouTube(String youTube) {
        this.youTube = youTube;
    }

    public static class Image {
        private String name;
        private String contentType;
        private byte[] data;

        // Getters and setters

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public byte[] getData() {
            return data;
        }

        public void setData(byte[] data) {
            this.data = data;
        }
    }
}
