package com.team7.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by jbeckman on 10/28/16.
 */
@Entity
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @ElementCollection(fetch = FetchType.EAGER)
    @OrderBy("number ASC")
    @JsonProperty("questions") @JsonInclude(JsonInclude.Include.NON_EMPTY)
    protected SortedSet<Question> questions = new TreeSet<>();

}
