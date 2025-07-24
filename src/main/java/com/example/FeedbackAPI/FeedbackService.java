package com.example.FeedbackAPI;

import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FeedbackService {
    private final FeedbackRepo repo;

    public FeedbackService(FeedbackRepo feedbackRepo) {
        this.repo = feedbackRepo;
    }

    public Feedback saveFeedback(Feedback feedback) {
        return repo.save(feedback);
    }

    public List<Feedback> getAllFeedback() {
        return repo.findAll();
    }
}

