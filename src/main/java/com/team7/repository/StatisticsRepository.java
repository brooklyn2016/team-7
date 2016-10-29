package com.team7.repository;

import com.team7.model.StatValTuple;
import com.team7.model.Statistics;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by joonho on 10/29/16.
 */
@Repository
public interface StatisticsRepository extends PagingAndSortingRepository<Statistics, Integer> {
    Statistics findOneByYearAndQuarter(int year, int quarter);
    List<Statistics> findAllByYear(int year);
}
