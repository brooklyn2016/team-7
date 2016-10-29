package com.team7.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by jbeckman on 10/28/16.
 */
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("pk_question")
    protected Long pk_question;

    @NotNull
    @JsonProperty("text")
    protected String text;

    public Question() {}

    public Question(String text) {
        this.text = text;
    }

    public Long getPkQuestion() {
        return pk_question;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question question = (Question) o;

        if (pk_question != null ? !pk_question.equals(question.pk_question) : question.pk_question != null)
            return false;
        return text.equals(question.text);

    }

    @Override
    public int hashCode() {
        int result = pk_question != null ? pk_question.hashCode() : 0;
        result = 31 * result + text.hashCode();
        return result;
    }
}
