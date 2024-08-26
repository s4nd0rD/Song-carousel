package com.song.carousel.config;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.song.carousel.model.Song;
import com.song.carousel.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final SongRepository songRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public DataInitializer(SongRepository songRepository, ObjectMapper objectMapper) {
        this.songRepository = songRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public void run(String... args) throws Exception {
        loadSongsToMongoDB();
    }

    private void loadSongsToMongoDB() throws IOException {
        var songs = getSongData();

        var anySongExists = songRepository.count() > 0;

        if (!anySongExists) {
            for (SongData songData : songs) {
                var imgFile = new ClassPathResource("images/" + songData.imageName);
                byte[] imageBytes = Files.readAllBytes(imgFile.getFile().toPath());

                Song.Image image = new Song.Image();
                image.setName(songData.imageName);
                image.setContentType("image/jpeg");
                image.setData(imageBytes);

                var song = new Song();
                song.setTitle(songData.title);
                song.setImage(image);
                song.setLyrics(songData.lyrics);
                song.setYouTube(songData.youTube);

                songRepository.save(song);
            }
            System.out.println("Songs have been successfully stored in MongoDB.");
        } else {
            System.out.println("Songs already exist in the database. Skipping initialization.");
        }
    }

    private List<SongData> getSongData() throws IOException {
        var jsonFile = new ClassPathResource("songs/songs.json");
        return objectMapper.readValue(jsonFile.getInputStream(), new TypeReference<>() {});
    }

    private static class SongData {
        String title;
        String imageName;
        String lyrics;
        String youTube;

        SongData(String title, String imageName, String lyrics, String youTube) {
            this.title = title;
            this.imageName = imageName;
            this.lyrics = lyrics;
            this.youTube = youTube;
        }
    }
}
