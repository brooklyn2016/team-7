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

    @NotNull
    @JsonProperty("community-id")
    @Column(name="c_id")
    protected Long cId;

    @ElementCollection(fetch = FetchType.EAGER)
    @OrderBy("s_id ASC")
    @JsonProperty("survey-question-answers") @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected SortedSet<SurveyQuestionAnswer> surveyQuestionAnswers = new TreeSet<>();

    @NotNull
    @JsonProperty("surveyor")
    protected String surveyor;

    @NotNull
    @JsonProperty("organization")
    protected String organization;

    @JsonProperty("total-grade")
    protected int totalGrade;

    @NotNull
    @JsonProperty("date-created")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone="UTC")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateCreated;

    public Survey(){}

    public Survey(Long cId, TreeSet<SurveyQuestionAnswer> SQAs, String surveyor, String organization, int totalGrade) {
        this.cId = cId;
        this.surveyQuestionAnswers = SQAs;
        this.surveyor = surveyor;
        this.organization = organization;
        this.totalGrade = totalGrade;
        this.dateCreated = new Date();
    }

    public Long getPid() {
        return pid;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public SortedSet<SurveyQuestionAnswer> getSurveyQuestionAnswers() {
        return surveyQuestionAnswers;
    }

    public void setSurveyQuestionAnswers(SortedSet<SurveyQuestionAnswer> surveyQuestionAnswers) {
        this.surveyQuestionAnswers = surveyQuestionAnswers;
    }

    public String getSurveyor() {
        return surveyor;
    }

    public void setSurveyor(String surveyor) {
        this.surveyor = surveyor;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public int getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(int totalGrade) {
        this.totalGrade = totalGrade;
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
