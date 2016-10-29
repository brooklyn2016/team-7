package com.team7.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by jbeckman on 10/28/16.
 */
@Embeddable
public class Question {

    @Id
    @NotNull
    @JsonProperty("number")
    int number;

    @NotNull
    @JsonProperty("text")
    String text;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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

        if (number != question.number) return false;
        return text.equals(question.text);

    }

    @Override
    public int hashCode() {
        int result = number;
        result = 31 * result + text.hashCode();
        return result;
    }
}
