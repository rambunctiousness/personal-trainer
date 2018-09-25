package io.rafo.personaltrainer.handlers;

import com.amazon.ask.attributes.AttributesManager;
import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by richardosborne on 24/09/2018.
 */
public class StartWorkoutIntentHandlerTest {
    StartWorkoutIntentHandler startWorkoutIntentHandler = new StartWorkoutIntentHandler();

    @Test
    public void testHandleWithExercisesSet() {
        HandlerInput handlerInput = mock(HandlerInput.class);
        AttributesManager attributesManager = mock(AttributesManager.class);

        when(handlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(handlerInput.getAttributesManager()).thenReturn(attributesManager);
        when(attributesManager.getSessionAttributes()).thenReturn(Collections.singletonMap("NUMBER", 5));

        Optional<Response> response = startWorkoutIntentHandler.handle(handlerInput);
        String responseString = response.toString();

        assertTrue(responseString.contains("title: PersonalTrainer"));
        assertTrue(responseString.contains("content: Starting your workout with 5 exercises"));
    }

    @Test
    public void testHandleWithNoExercises() {
        HandlerInput handlerInput = mock(HandlerInput.class);
        AttributesManager attributesManager = mock(AttributesManager.class);

        when(handlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());
        when(handlerInput.getAttributesManager()).thenReturn(attributesManager);
        when(attributesManager.getSessionAttributes()).thenReturn(null);

        Optional<Response> response = startWorkoutIntentHandler.handle(handlerInput);
        String responseString = response.toString();

        assertTrue(responseString.contains("title: PersonalTrainer"));
        assertTrue(responseString.contains("content: First please tell me how many exercises are in your circuit"));
    }

}