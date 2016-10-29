package com.team7.repository;

import com.team7.model.Statistics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.stream.StreamSupport;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by joonho on 10/29/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StatisticsRepositoryTest {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Test
    public void nothingInRepository() throws Exception {
        long count = StreamSupport.stream(statisticsRepository.findAll().spliterator(), false).count();
        assertThat(count).isEqualTo(0);
    }

    @Test
    public void statisticsAddedToRepository() throws Exception {
        long count = StreamSupport.stream(statisticsRepository.findAll().spliterator(), false).count();
        assertThat(count).isEqualTo(0);

        Statistics stat = new Statistics();
        stat.setYearQuarter(2016, 2);
        statisticsRepository.save(stat);

        long countAfter = StreamSupport.stream(statisticsRepository.findAll().spliterator(), false).count();
        assertThat(countAfter).isEqualTo(1);
    }

    @Test
    public void statisticsAddedMultipleToRepository() throws Exception {
        long count = StreamSupport.stream(statisticsRepository.findAll().spliterator(), false).count();
        assertThat(count).isEqualTo(0);

        Statistics stat1 = new Statistics();
        stat1.setYearQuarter(2016, 2);
        statisticsRepository.save(stat1);

        Statistics stat2 = new Statistics();
        stat2.setYearQuarter(2016, 3);
        statisticsRepository.save(stat2);

        Statistics stat3 = new Statistics();
        stat3.setYearQuarter(2016, 3);
        statisticsRepository.save(stat3);

        long countAfter = StreamSupport.stream(statisticsRepository.findAll().spliterator(), false).count();
        assertThat(countAfter).isEqualTo(3);
    }

    @Test
    public void statisticsFindChangeByYearAndQuarter() throws Exception {
        long count = StreamSupport.stream(statisticsRepository.findAll().spliterator(), false).count();
        assertThat(count).isEqualTo(0);

        Statistics stat1 = new Statistics();
        stat1.setYearQuarter(2016, 2);
        statisticsRepository.save(stat1);

        for (Statistics s : statisticsRepository.findAll()) {
            assertThat(s.getYear()).isEqualTo(2016);
            assertThat(s.getQuarter()).isEqualTo(2);
            assertThat(s.getYearQuarter()).isEqualTo(201602);
        }

        stat1.setYear(2013);
        statisticsRepository.save(stat1);

        for (Statistics s : statisticsRepository.findAll()) {
            assertThat(s.getYear()).isEqualTo(2013);
            assertThat(s.getQuarter()).isEqualTo(2);
            assertThat(s.getYearQuarter()).isEqualTo(201302);
        }

        stat1.setQuarter(4);
        statisticsRepository.save(stat1);

        for (Statistics s : statisticsRepository.findAll()) {
            assertThat(s.getYear()).isEqualTo(2013);
            assertThat(s.getQuarter()).isEqualTo(4);
            assertThat(s.getYearQuarter()).isEqualTo(201304);
        }
    }

//    @Test
//    public void statisticsGetStat() throws Exception {
//        long count = StreamSupport.stream(statisticsRepository.findAll().spliterator(), false).count();
//        assertThat(count).isEqualTo(0);
//
//        Statistics stat1 = new Statistics();
//        stat1.setYearQuarter(2016, 2);
//        stat1.addStatVal("deaths", 2);
//        stat1.addStatVal("saves", 4);
//        statisticsRepository.save(stat1);
//    }

}
