package com.team7.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by jbeckman on 10/29/16.
 */
@Entity
public class Community {

    @JsonProperty("region")
    protected String region;

    @NotNull
    @JsonProperty("country")
    protected String country;

    @JsonProperty("surverys")
    HashSet<Long> surverySet = new HashSet<>();

    @JsonProperty("stats")
//    @OrderBy("stat ASC")
    SortedSet<Long> statsSet = new TreeSet<>();


    public Community(String region, String country) {
        this.region = region;
        this.country = country;
    }
}
