package io.rafo.personaltrainer;

import com.amazon.ask.Skill;
import com.amazon.ask.model.RequestEnvelope;
import com.amazon.ask.model.ResponseEnvelope;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by richardosborne on 18/09/2018.
 */
public class PersonalTrainerStreamHandlerTest {

    PersonalTrainerStreamHandler personalTrainerStreamHandler = new PersonalTrainerStreamHandler();

    @Test
    public void testGetSkill() {
        Skill skill = personalTrainerStreamHandler.getSkill();
        assertEquals(skill.getClass().getName(), "com.amazon.ask.Skill");
    }
}