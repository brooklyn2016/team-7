package com.team7;

import com.team7.model.*;
import com.team7.repository.CommunityRepository;
import com.team7.repository.QuestionRepository;
import com.team7.repository.StatisticsRepository;
import com.team7.repository.SurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import javax.annotation.PostConstruct;

/**
 * Created by sd95 on 10/29/16.
 */
@Component
public class SeedDatabase {
    @Autowired
    CommunityRepository communityRepository;

    @Autowired
    QuestionRepository questionRepository;

    @Autowired
    SurveyRepository surveyRepository;

    @Autowired
    StatisticsRepository statisticsRepository;

    @PostConstruct
    public void seedCommunities(){
        communityRepository.save(new Community("Hydrabad", "India", "Village A"));
        communityRepository.save(new Community("Hydrabad", "India", "Village B"));
        communityRepository.save(new Community("Central", "Ghana", "Village C"));
        communityRepository.save(new Community("Ashanti", "Ghana", "Village D"));
        communityRepository.save(new Community("", "Haiti", "Village E"));
        communityRepository.save(new Community("", "Haiti", "Village F"));

        for(Community community : communityRepository.findAll()){
            System.out.println("Community " + community);
        }

        seedQuestions();
        seedSurveys();
        seedStatistics();
    }

    public void seedQuestions(){
        questionRepository.save(new Question("Traffickers, whether from the village or from outside the village, cannot operate any more."));
        questionRepository.save(new Question("No one residing in this village is in any form of slavery."));
        questionRepository.save(new Question("People who migrate from this community for work are NOT being trafficked."));
        questionRepository.save(new Question("None of the children in this village are being exploited for commercial sex."));
        questionRepository.save(new Question("None of the children in this village are performing hazardous labor."));
        questionRepository.save(new Question("Residents in this village know how to protect themselves from trafficking during migration for work."));
        questionRepository.save(new Question("Residents understand the risks of sending children to distant jobs, e.g. domestic work, mining or stone quarries, and circuses."));
        questionRepository.save(new Question("Residents are able to identify and pressure known traffickers to leave when they appear in the community."));
        questionRepository.save(new Question("Residents in this village know how to avoid debt bondage."));
        questionRepository.save(new Question("Residents understand the risks of early or forced marriage and false offers of marriage."));
        questionRepository.save(new Question("Residents understand the risks of early or forced marriage and false offers of marriage."));
        questionRepository.save(new Question("Residents are able to confront domestic violence."));

        for (Question question: questionRepository.findAll()) {
            System.out.println("Question " + question);
        }


    }

    public void seedSurveys(){
        surveyRepository.save(new Survey(new Long(1L), (TreeSet< SurveyQuestionAnswer>) null, "Foo", "bar", 100));
        surveyRepository.save(new Survey(new Long(1L), (TreeSet< SurveyQuestionAnswer>) null, "Foo2", "bar2", 70));
        surveyRepository.save(new Survey(new Long(1L), (TreeSet< SurveyQuestionAnswer>) null, "Foo3", "bar3", 80));
        surveyRepository.save(new Survey(new Long(1L), (TreeSet< SurveyQuestionAnswer>) null, "Foo4", "bar4", 90));
        surveyRepository.save(new Survey(new Long(1L), (TreeSet< SurveyQuestionAnswer>) null, "Foo5", "bar5", 60));

        for (Survey survey : surveyRepository.findAll()) {
            System.out.println("Survey " + survey);
        }
    }

    public void seedStatistics(){
        List<StatValTuple> list = new ArrayList<StatValTuple>();

        list.add(new StatValTuple("Slaves freed", 125));
        list.add(new StatValTuple("Communities receiving support", 30));
        list.add(new StatValTuple("Community Members educated on rights and risks", 500));
        list.add(new StatValTuple("Communities that have reached full maturity", 200));
        list.add(new StatValTuple("Slaves effectively re-intergrated", 20));

        System.out.println(list);

        Statistics stats1 = statisticsRepository.save(new Statistics(2016, 1, 1L));
        Statistics stats2 = statisticsRepository.save(new Statistics(2016, 1, 3L));
        Statistics stats3 = statisticsRepository.save(new Statistics(2016, 1, 5L));

        stats1.setStatVals(list);
        stats2.setStatVals(list);
        stats3.setStatVals(list);

        statisticsRepository.save(stats1);
        statisticsRepository.save(stats2);
        statisticsRepository.save(stats3);

        for(Statistics statistics: statisticsRepository.findAll()){
            System.out.println("Statistics" + statistics);
        }
    }

}
