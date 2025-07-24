package com.example.FeedbackAPI;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private final FeedbackService service;

    public FeedbackController(FeedbackService feedbackService) {
        this.service = feedbackService;
    }


    @PostMapping
    public ResponseEntity<Feedback> submitFeedback(@RequestBody @Valid Feedback feedback) {
        Feedback savedFeedback = service.saveFeedback(feedback);
        return new ResponseEntity<>(savedFeedback, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return service.getAllFeedback();
    }
}