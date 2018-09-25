package io.rafo.personaltrainer.handlers;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class SetNumberOfExercisesIntentHandler implements RequestHandler {

    public static final String NUMBER_SLOT = "Number";

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("SetNumberOfExercisesIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = getNumberOfExercisesResponse(input);
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("PersonalTrainer", speechText)
                .build();
    }

    public String getNumberOfExercisesResponse(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        Slot numberOfExercisesSlot = slots.get(NUMBER_SLOT);
        String response;

        if (numberOfExercisesSlot != null) {
            String numberOfExercisesString = numberOfExercisesSlot.getValue();
            Integer numberOfExercises = Integer.valueOf(numberOfExercisesString);

            if (numberOfExercises < 1) {
                return "Number of exercises must be more than zero";
            }

            input.getAttributesManager().setSessionAttributes(Collections.singletonMap("NUMBER", numberOfExercises));
            response = "Setting number of exercises to " + numberOfExercisesString;
        } else {
            response = "I'm not sure how many exercises you want";
        }

        return response;
    }
}
