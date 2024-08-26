package com.song.carousel.controller;

import com.song.carousel.model.Song;
import com.song.carousel.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SongController {

    private final SongService songService;

    @Autowired
    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/song")
    public String getRandomSong(Model model) {
        Song randomSong = songService.getRandomSong();
        if (randomSong == null) {
            model.addAttribute("message", "No songs available.");
            return "selected-song";
        }
        model.addAttribute("song", randomSong);
        return "selected-song";
    }

    @GetMapping("/image/{songId}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable String songId) {
        return songService.getImage(songId);
    }
}