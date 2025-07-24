
package com.example.FeedbackAPI;

import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestFeedbackInvalid {
    @Mock
    private FeedbackRepo feedbackRepository;

    @InjectMocks
    private FeedbackService feedbackService;

    public TestFeedbackInvalid() {
        MockitoAnnotations.openMocks(this); // Initializes mocks
    }

@Test
public void invalidFeedback() {

    Feedback feedback = new Feedback();
    feedback.setName("Ab");
    feedback.setEmail("ab@");
    feedback.setMessage("Test feedback.");


    assertThrows(ConstraintViolationException.class, () -> {
        feedbackService.saveFeedback(feedback);
    });


    verify(feedbackRepository, never()).save(any(Feedback.class));
}
}