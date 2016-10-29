package com.team7.repository;

import com.team7.model.Community;
import com.team7.model.StatValTuple;
import com.team7.model.Statistics;
import com.team7.model.Survey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by joonho on 10/29/16.
 */
@Repository
public interface StatisticsRepository extends PagingAndSortingRepository<Statistics, Integer> {
    Statistics findOneByYearAndQuarter(int year, int quarter);
    List<Statistics> findAllByYear(int year);

//    @Query("Select j.val from Statistics s join s.statVals j where j.stat = :stat")
//    double findOneByStat(@Param("stat") String stat);

    List<Statistics> findAllByCId(Long c_id);
}
