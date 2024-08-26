package com.song.carousel.controller;

import com.song.carousel.model.Song;
import com.song.carousel.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.Random;

@Controller
public class SongController {

    private final SongRepository songRepository;

    @Autowired
    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/song")
    public String getRandomSong(Model model) {
        var songs = songRepository.findAll();

        if (songs.isEmpty()) {
            model.addAttribute("message", "No songs available.");
            return "selected-song";
        }

        var random = new Random();
        var randomSong = songs.get(random.nextInt(songs.size()));

        model.addAttribute("song", randomSong);

        return "selected-song";
    }

    @GetMapping("/image/{songId}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable String songId) {
        Optional<Song> optionalSong = songRepository.findById(songId);

        if (optionalSong.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Song song = optionalSong.get();
        byte[] imageData = song.getImage().getData();
        String imageName = song.getImage().getName();
        String contentType = song.getImage().getContentType();

        ByteArrayResource resource = new ByteArrayResource(imageData);

        // Return image as ResponseEntity
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, contentType)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + imageName + "\"")
                .body(resource);
    }
}
