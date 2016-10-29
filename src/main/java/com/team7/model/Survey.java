package com.team7.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by jbeckman on 10/28/16.
 */
@Entity
public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long pid;

    @ElementCollection(fetch = FetchType.EAGER)
    @OrderBy("s_id ASC")
    @JsonProperty("survey-question-answers") @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected SortedSet<SurveyQuestionAnswer> surveyQuestionAnswers = new TreeSet<>();

    @NotNull
    @JsonProperty("surveyor")
    protected String surveyor;

    @NotNull
    @JsonProperty("date-created")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone="UTC")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getSurveyor() {
        return surveyor;
    }

    public void setSurveyor(String surveyor) {
        this.surveyor = surveyor;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Survey survey = (Survey) o;

        if (pid != null ? !pid.equals(survey.pid) : survey.pid != null) return false;
        if (!surveyor.equals(survey.surveyor)) return false;
        return dateCreated.equals(survey.dateCreated);

    }

    @Override
    public int hashCode() {
        int result = pid != null ? pid.hashCode() : 0;
        result = 31 * result + surveyor.hashCode();
        result = 31 * result + dateCreated.hashCode();
        return result;
    }
}
