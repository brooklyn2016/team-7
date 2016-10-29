package com.team7.repository;

import com.team7.model.Question;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sd95 on 10/29/16.
 */
@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
}
