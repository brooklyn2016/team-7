package com.team7.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.TreeSet;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by jbeckman on 10/29/16.
 */
public class SurveyJsonTest {

    private static final String TIMESTAMP_JSON_PREFIX = "{\"pid\":null,\"community-id\":1,\"survey-question-answers\":[{\"survey-id\":2,\"question-id\":1,\"section\":\"Some section\",\"section-grade\":88,\"answer\":\"Charizard\"},{\"survey-id\":3,\"question-id\":5,\"section\":\"Some section\",\"section-grade\":83,\"answer\":\"Pikachu\"}],\"surveyor\":\"Surveyor's name\",\"organization\":\"I'm an organization, duh\",\"total-grade\":42,\"date-created\":\"";
    private static final String TIMESTAMP_JSON_SUFFIX = "\"}";

    @Test
    public void basicSerializationWorks() throws JsonProcessingException {
        Survey survey = new Survey(1L, null, "Surveyor's name", "I'm an organization, duh", 42);

        TreeSet<SurveyQuestionAnswer> SQAs = new TreeSet<>();
        SQAs.add(new SurveyQuestionAnswer(2L, 1L, "Some section", 88, "Charizard"));
        SQAs.add(new SurveyQuestionAnswer(3L, 5L, "Some section", 83, "Pikachu"));
        survey.setSurveyQuestionAnswers(SQAs);

        String serialized = new ObjectMapper().writeValueAsString(survey);

        assertTrue(serialized.startsWith(TIMESTAMP_JSON_PREFIX));
        assertTrue(serialized.endsWith(TIMESTAMP_JSON_SUFFIX));

        String dateString = serialized.substring(TIMESTAMP_JSON_PREFIX.length(), serialized.length()-TIMESTAMP_JSON_SUFFIX.length());

        assertTrue("Date Didn't match the expected format:  'yyyy-MM-dd'T'HH:mm:ss.SSSZ'",
                dateString.matches("\\d\\d\\d\\d-\\d\\d-\\d\\dT\\d\\d:\\d\\d:\\d\\d\\.\\d\\d\\d\\+\\d\\d\\d\\d"));
    }

    @Test
    public void basicDeserializationWorks() throws Exception {
        Survey survey = new Survey(1L, null, "Surveyor's name", "I'm an organization, duh", 42);

        TreeSet<SurveyQuestionAnswer> SQAs = new TreeSet<>();
        SQAs.add(new SurveyQuestionAnswer(2L, 1L, "Some section", 88, "Charizard"));
        SQAs.add(new SurveyQuestionAnswer(3L, 5L, "Some section", 83, "Pikachu"));
        survey.setSurveyQuestionAnswers(SQAs);

        Date now = survey.getDateCreated();

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));

        //Convert JSON to Event object
        Survey survey2 = new ObjectMapper().reader().forType(Survey.class).readValue(TIMESTAMP_JSON_PREFIX+formatter.format(now)+TIMESTAMP_JSON_SUFFIX);

        assertNotNull(survey2);
        assertEquals(survey, survey2);
    }

}



