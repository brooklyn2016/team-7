package com.team7.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by jbeckman on 10/28/16.
 */
@Embeddable
public class SurveyQuestionAnswer implements Comparable<SurveyQuestionAnswer> {

    @NotNull
    @JsonProperty("survey-id")
    protected Long s_id;

    @NotNull
    @JsonProperty("question-id")
    protected Long q_id;

    @NotNull
    @JsonProperty("section")
    protected String section;

    @JsonProperty("section-grade")
    protected int sectionGrade;

    @JsonProperty("answer")
    protected String answer;

    public SurveyQuestionAnswer() {
    }

    public Long getS_id() {
        return s_id;
    }

    public void setS_id(Long s_id) {
        this.s_id = s_id;
    }

    public Long getQ_id() {
        return q_id;
    }

    public void setQ_id(Long q_id) {
        this.q_id = q_id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int compareTo(SurveyQuestionAnswer sqa) {
        if(s_id > sqa.getS_id()) {
            return 1;
        } else if (s_id < sqa.getS_id()){
            return -1;
        } else {
            if(q_id > sqa.getQ_id()) {
                return 1;
            } else if (q_id < sqa.getQ_id()){
                return -1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SurveyQuestionAnswer that = (SurveyQuestionAnswer) o;

        if (sectionGrade != that.sectionGrade) return false;
        if (!s_id.equals(that.s_id)) return false;
        if (!q_id.equals(that.q_id)) return false;
        if (!section.equals(that.section)) return false;
        return answer != null ? answer.equals(that.answer) : that.answer == null;

    }

    @Override
    public int hashCode() {
        int result = s_id.hashCode();
        result = 31 * result + q_id.hashCode();
        result = 31 * result + section.hashCode();
        result = 31 * result + sectionGrade;
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        return result;
    }
}
