package com.team7.repository;

import com.team7.model.Survey;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
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
        survey.setOrganization("Some organization");
        survey.setcId(1L);
        surveyRepository.save(survey);

        long countAfter = StreamSupport.stream(surveyRepository.findAll().spliterator(), false).count();
        assertThat(countAfter).isEqualTo(1);
    }

    @Test
    public void multipleSurveysCanBeAddedRepository() throws Exception {
        long count = StreamSupport.stream(surveyRepository.findAll().spliterator(), false).count();
        assertThat(count).isEqualTo(0);

        Survey survey = new Survey();
        survey.setDateCreated(new Date());
        survey.setSurveyor("New name");
        survey.setOrganization("Some organization");
        survey.setcId(1L);
        surveyRepository.save(survey);

        Survey survey2 = new Survey();
        survey2.setDateCreated(new Date());
        survey2.setSurveyor("New name2");
        survey2.setOrganization("Some other organization");
        survey2.setcId(2L);
        surveyRepository.save(survey2);

        long countAfter = StreamSupport.stream(surveyRepository.findAll().spliterator(), false).count();
        assertThat(countAfter).isEqualTo(2);
    }

    @Test
    public void specificSurveyIsFoundBySurveyor() throws Exception {
        long count = StreamSupport.stream(surveyRepository.findAll().spliterator(), false).count();
        assertThat(count).isEqualTo(0);

        Survey survey1 = new Survey();
        survey1.setDateCreated(new Date());
        survey1.setSurveyor("New name");
        survey1.setOrganization("Some organization");
        survey1.setcId(1L);
        surveyRepository.save(survey1);

        Survey survey2 = new Survey();
        survey2.setDateCreated(new Date());
        survey2.setSurveyor("New name2");
        survey2.setOrganization("Some other organization");
        survey2.setcId(2L);
        surveyRepository.save(survey2);

        List<Survey>surveys = surveyRepository.findAllBySurveyor("New name");
        assertThat(surveys.size()).isEqualTo(1);
        assertThat(survey1).isEqualTo(surveys.get(0));
    }
}
