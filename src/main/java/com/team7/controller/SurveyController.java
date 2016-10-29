package com.team7.controller;

import com.team7.model.Community;
import com.team7.model.Survey;
import com.team7.repository.CommunityRepository;
import com.team7.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by jbeckman on 10/29/16.
 */
@RestController
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    @RequestMapping(value = "/community/surveys", method = RequestMethod.GET)
    public List<Survey> getSurveys(@RequestBody @Valid Community community) {

        return surveyRepository.findAllByCId(community.getPk_community());
    }

    @RequestMapping(value = "/community/survey", method = RequestMethod.POST)
    public ResponseEntity<Survey> createSurvey(@RequestBody @Valid Survey survey) {

        Survey savedSurvey = surveyRepository.save(survey);

        if(savedSurvey == null) {
            return new ResponseEntity<Survey>((Survey)null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Survey>(savedSurvey, HttpStatus.CREATED);
        }
    }

    /*
    TODO: Create repository index to find top 10 surveys determined by dateCreated ASC

    @RequestMapping(value = "/community/surveys/lastest10", method = RequestMethod.GET)
    public List<Survey> getSurvey(@RequestBody @Valid Community community) {

        return surveyRepository.findAllByCId(community.getPk_community());
    }
     */

}
