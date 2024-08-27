package com.song.carousel.controller;

import com.song.carousel.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SuggestionController {

    private final EmailService emailService;

    public SuggestionController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/suggestion")
    public String handleSuggestion(@RequestParam("suggestion") String suggestion, Model model) {
        emailService.sendEmail("sander.droogsma@incentro.com", "New Song Suggestion", suggestion);
        model.addAttribute("message", "Bedankt voor je suggestie! We gaan er mee aan de slag.");
        return "suggestion";
    }
}