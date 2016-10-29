package com.team7.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by jbeckman on 10/28/16.
 */
@Embeddable
public class SurveyQuestionAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @NotNull
    protected Long s_id;

    @NotNull
    protected Long q_id;

    @JsonProperty("answer")
    protected String answer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SurveyQuestionAnswer that = (SurveyQuestionAnswer) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (s_id != null ? !s_id.equals(that.s_id) : that.s_id != null) return false;
        if (q_id != null ? !q_id.equals(that.q_id) : that.q_id != null) return false;
        return answer != null ? answer.equals(that.answer) : that.answer == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (s_id != null ? s_id.hashCode() : 0);
        result = 31 * result + (q_id != null ? q_id.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        return result;
    }
}
