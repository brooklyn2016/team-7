package com.team7.controller;

import com.team7.model.Community;
import com.team7.model.Survey;
import com.team7.model.SurveyQuestionAnswer;
import com.team7.model.User;
import com.team7.repository.CommunityRepository;
import com.team7.repository.SurveyRepository;
import com.team7.repository.UserRepository;
import com.team7.security.WebContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by jbeckman on 10/29/16.
 */
@RestController
public class SurveyController {

    @Autowired
    private SurveyRepository surveyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebContext webContext;

    @RequestMapping(value = "/community/surveys", method = RequestMethod.GET)
    public List<Survey> getSurveys(@RequestHeader Long communityID) {

        return surveyRepository.findAllByCId(communityID);
    }

    @RequestMapping(value = "/community/survey", method = RequestMethod.POST)
    public ResponseEntity<Survey> createSurvey(@RequestHeader(value = "communityId") Long communityId,
                                               @RequestHeader(value = "totalGrade") int totalGrade,
                                               @RequestHeader(value = "organization") String organization,
                                               @RequestBody @Valid List<SurveyQuestionAnswer> surveyQuestionAnswers) {

        User user = userRepository.findByUsername(webContext.getUsername());
        if(user == null || surveyQuestionAnswers.size() == 0) {
            return new ResponseEntity<Survey>((Survey)null, HttpStatus.BAD_REQUEST);
        }

        Survey savedSurvey = surveyRepository.save(new Survey(communityId,
                new TreeSet(surveyQuestionAnswers),
                webContext.getUsername(),
                organization,
                totalGrade
        ));

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
