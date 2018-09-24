package io.rafo.personaltrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.requestType;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by richardosborne on 24/09/2018.
 */
public class LaunchRequestHandlerTest {
    LaunchRequestHandler launchRequestHandler = new LaunchRequestHandler();

    @Test
    public void testHandle() {
        HandlerInput handlerInput = mock(HandlerInput.class);
        when(handlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());
        Optional<Response> response = launchRequestHandler.handle(handlerInput);
        String responseString = response.toString();

        assertTrue(responseString.contains("title: PersonalTrainer"));
        assertTrue(responseString.contains("content: Welcome to Personal Trainer, tell me how many exercises are in your circuit"));
    }

}