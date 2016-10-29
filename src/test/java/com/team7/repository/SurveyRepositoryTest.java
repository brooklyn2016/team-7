package com.team7.repository;

import com.team7.model.Survey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jbeckman on 10/28/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class SurveyRepositoryTest {

    @Autowired
    private SurveyRepository surveyRepository;

    @Test
    public void nothingInRepository() throws Exception {
        long count = StreamSupport.stream(surveyRepository.findAll().spliterator(), false).count();
        assertThat(count).isEqualTo(0);
    }

    @Test
    public void surveyIsAddedToRepository() throws Exception {
        long count = StreamSupport.stream(surveyRepository.findAll().spliterator(), false).count();
        assertThat(count).isEqualTo(0);

        Survey survey = new Survey();
        survey.setDateCreated(new Date());
        survey.setSurveyor("New name");
        surveyRepository.save(survey);

        long countAfter = StreamSupport.stream(surveyRepository.findAll().spliterator(), false).count();
        assertThat(countAfter).isEqualTo(1);
    }
}
