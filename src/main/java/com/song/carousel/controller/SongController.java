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
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/song-archive")
    public String getSongArchive(Model model) {
        var songOverview = songService.getAllSongTitlesAndIds();
        model.addAttribute("songOverview", songOverview);
        return "song-archive";
    }

    @GetMapping("/song/{songId}")
    public String getSongById(@PathVariable String songId, @RequestParam(required = false) String origin, Model model) {
        var song = songService.getSongById(songId);
        if (song == null) {
            model.addAttribute("message", "Het liedje is niet gevonden.");
            return "selected-song";
        }
        model.addAttribute("song", song);
        if (origin != null) {
            model.addAttribute("origin", origin);
        }
        return "selected-song";
    }
}