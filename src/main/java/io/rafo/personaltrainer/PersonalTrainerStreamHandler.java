/*
     Copyright 2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/

package io.rafo.personaltrainer;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import io.rafo.personaltrainer.handlers.*;

public class PersonalTrainerStreamHandler extends SkillStreamHandler {

    private static final String SKILL_ID = "amzn1.ask.skill.ead15932-3541-402e-bbe3-e99cd5d1d903";

    static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new CancelandStopIntentHandler(),
                        new HelpIntentHandler(),
                        new LaunchRequestHandler(),
                        new SessionEndedRequestHandler(),
                        new FallbackIntentHandler(),
                        new StartWorkoutIntentHandler())
                .withSkillId(SKILL_ID)
                .build();
    }

    public PersonalTrainerStreamHandler() {
        super(getSkill());
    }

}
