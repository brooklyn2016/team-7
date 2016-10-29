package com.team7.controller;

import com.team7.model.Community;
import com.team7.model.StatValTuple;
import com.team7.model.Statistics;
import com.team7.repository.CommunityRepository;
import com.team7.repository.StatisticsRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by joonho on 10/29/16.
 */
@RestController
public class StatisticsController {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Autowired
    private CommunityRepository communityRepository;

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public ResponseEntity<Statistics> getStatistics(@RequestHeader(value = "year") int year,
                                                    @RequestHeader(value = "quarter") int quarter) {
        Statistics statistics = statisticsRepository.findOneByYearAndQuarter(year, quarter);

        if(statistics == null) {
            return new ResponseEntity<Statistics>((Statistics) null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Statistics>(statistics, HttpStatus.CREATED);
        }
    }

    @RequestMapping(value = "/statistics/all", method = RequestMethod.GET)
    public Map<String, List<StatValTuple>> getAllCountryStatistics() {
        Map<String, List<StatValTuple>> statisticsMap = new HashMap<>();

        for (Community community : communityRepository.findAll()) {
            for (Statistics stats : statisticsRepository.findAllByCId(community.getPk_community())) {
                System.out.println(community.getCountry() + "   " + stats.getStatVals());
                statisticsMap.put(community.getCountry(), stats.getStatVals());
            }
        }

        return statisticsMap;
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.POST)
    public ResponseEntity<Statistics> setStatistics(@RequestHeader(value = "year") int year,
                                                  @RequestHeader(value = "quarter") int quarter,
                                                  @RequestHeader(value = "c_id") long c_id) {
        Statistics statistics = statisticsRepository.save(new Statistics(year, quarter, c_id));

        if(statistics == null) {
            return new ResponseEntity<Statistics>((Statistics) null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<Statistics>(statistics, HttpStatus.CREATED);
        }

    }
//
//    @RequestMapping(value = "/community?queryFor={queryString}", method = RequestMethod.GET)
//    public ResponseEntity<List<Community>> queryCommunity(@PathVariable("queryString") String queryString) {
//
//        List<Community> communities = communityRepository.findByQuery(queryString);
//
//        if(communities.size() == 0) {
//            return new ResponseEntity<>((List<Community>)null, HttpStatus.BAD_REQUEST);
//        } else {
//            return new ResponseEntity<>(communities, HttpStatus.CREATED);
//        }
//
//    }

}
