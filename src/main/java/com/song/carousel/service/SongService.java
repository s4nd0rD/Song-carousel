package com.song.carousel.service;

import com.song.carousel.model.Song;
import com.song.carousel.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class SongService {

    private final SongRepository songRepository;

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song getRandomSong() {
        List<Song> songs = songRepository.findAll();
        if (songs.isEmpty()) {
            return null;
        }
        Random random = new Random();
        return songs.get(random.nextInt(songs.size()));
    }

    public ResponseEntity<ByteArrayResource> getImage(String songId) {
        Optional<Song> optionalSong = songRepository.findById(songId);
        if (optionalSong.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Song song = optionalSong.get();
        byte[] imageData = song.getImage().getData();
        String imageName = song.getImage().getName();
        String contentType = song.getImage().getContentType();

        ByteArrayResource resource = new ByteArrayResource(imageData);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageName + "\"")
                .body(resource);
    }
}