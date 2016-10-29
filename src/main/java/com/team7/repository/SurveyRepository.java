package com.team7.repository;

import com.team7.model.Survey;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by jbeckman on 10/28/16.
 */
@Repository
public interface SurveyRepository extends PagingAndSortingRepository<Survey, String> {
    List<Survey> findAllBySurveyor(String surveyor);
    List<Survey> findAllByCId(Long c_id);
}
