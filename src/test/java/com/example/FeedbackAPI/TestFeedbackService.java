
package com.example.FeedbackAPI;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class TestFeedbackService {
    @Mock
    private FeedbackRepo feedbackRepository;

    @InjectMocks
    private FeedbackService feedbackService;

    public TestFeedbackService() {
        MockitoAnnotations.openMocks(this); // Initializes mocks
    }
    @Test
    void saveFeedbackTest() {
        Feedback feedback = new Feedback();
        feedback.setName("ABC XYZ");
        feedback.setEmail("abc.xyz@mail.com");
        feedback.setMessage("Test feedback");

        when(feedbackRepository.save(any(Feedback.class))).thenReturn(feedback);

        Feedback savedFeedback = feedbackService.saveFeedback(feedback);


        assertNotNull(savedFeedback);
        assertEquals("ABC XYZ", savedFeedback.getName());
        assertEquals("abc.xyz@mail.com", savedFeedback.getEmail());
        assertEquals("Test feedback", savedFeedback.getMessage());


        verify(feedbackRepository, times(1)).save(any(Feedback.class));
        System.out.println("Save test success");

    }

//@Test
//public void invalidFeedback() {
//
//    Feedback feedback = new Feedback();
//    feedback.setName("Ab");
//    feedback.setEmail("ab@");
//    feedback.setMessage("Test feedback.");
//
//
//    assertThrows(ConstraintViolationException.class, () -> {
//        feedbackService.saveFeedback(feedback);
//    });
//
//
//    verify(feedbackRepository, never()).save(any(Feedback.class));
//}
}