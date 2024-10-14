package com.song.carousel.service;

import com.song.carousel.model.Song;
import com.song.carousel.model.SongOverviewItem;
import com.song.carousel.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final Random random = new Random();

    @Autowired
    public SongService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    public Song getRandomSong() {
        var songs = songRepository.findAll();
        if (songs.isEmpty()) {
            return null;
        }
        var randomValue = this.random.nextInt(songs.size());
        return songs.get(randomValue);
    }

    public ResponseEntity<ByteArrayResource> getImage(String songId) {
        var optionalSong = songRepository.findById(songId);
        if (optionalSong.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var song = optionalSong.get();
        var imageData = song.getImage().getData();
        var imageName = song.getImage().getName();
        var contentType = song.getImage().getContentType();
        var resource = new ByteArrayResource(imageData);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageName + "\"")
                .body(resource);
    }

    public List<SongOverviewItem> getAllSongTitlesAndIds() {
        return songRepository.findAll().stream()
                .map(song -> new SongOverviewItem(song.getId(), song.getTitle()))
                .collect(Collectors.toList());
    }

    public Song getSongById(String songId) {
        return songRepository.findById(songId).orElse(null);
    }
}