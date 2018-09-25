package io.rafo.personaltrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.model.*;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import static io.rafo.personaltrainer.handlers.SetNumberOfExercisesIntentHandler.NUMBER_SLOT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by richardosborne on 24/09/2018.
 */
public class SetNumberOfExercisesIntentHandlerTest {
    SetNumberOfExercisesIntentHandler setNumberOfExercisesIntentHandler = new SetNumberOfExercisesIntentHandler();

    @Test
    public void testGetNumberOfExercisesZero() {

        Slot numberOfExercisesSlot = Slot.builder().withValue("0").build();
        Map<String, Slot> slotMap = new LinkedHashMap<>();
        slotMap.put(NUMBER_SLOT, numberOfExercisesSlot);

        Intent intent = Intent.builder().withSlots(slotMap).build();
        IntentRequest request = IntentRequest.builder().withIntent(intent).build();
        RequestEnvelope requestEnvelope = RequestEnvelope.builder().withRequest(request).build();
        HandlerInput handlerInput = HandlerInput.builder().withRequestEnvelope(requestEnvelope).build();

        String numberOfExercisesResponse = setNumberOfExercisesIntentHandler.getNumberOfExercisesResponse(handlerInput);

        assertEquals("Number of exercises must be more than zero", numberOfExercisesResponse);
    }

    @Test
    public void testHandleNoExercises() {
        Map<String, Slot> slotMap = new LinkedHashMap<>();

        Intent intent = Intent.builder().withSlots(slotMap).build();
        IntentRequest request = IntentRequest.builder().withIntent(intent).build();
        RequestEnvelope requestEnvelope = RequestEnvelope.builder().withRequest(request).build();
        HandlerInput handlerInput = HandlerInput.builder().withRequestEnvelope(requestEnvelope).build();

        Optional<Response> handle = setNumberOfExercisesIntentHandler.handle(handlerInput);

        assertTrue(handle.toString().contains("title: PersonalTrainer"));
        assertTrue(handle.toString().contains("content: I'm not sure how many exercises you want"));
    }

}