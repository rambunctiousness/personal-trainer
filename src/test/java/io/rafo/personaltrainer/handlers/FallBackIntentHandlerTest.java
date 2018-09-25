package io.rafo.personaltrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.Response;
import com.amazon.ask.response.ResponseBuilder;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by richardosborne on 25/09/2018.
 */
public class FallBackIntentHandlerTest {
    FallbackIntentHandler fallbackIntentHandler = new FallbackIntentHandler();

    @Test
    public void testHandle() {
        HandlerInput handlerInput = mock(HandlerInput.class);
        when(handlerInput.getResponseBuilder()).thenReturn(new ResponseBuilder());
        Optional<Response> handle = fallbackIntentHandler.handle(handlerInput);
        String responseString = handle.toString();

        assertTrue(responseString.contains("title: PersonalTrainer"));
        assertTrue(responseString.contains("content: Sorry, I don't know that. You can say try saying help!"));
    }

}
