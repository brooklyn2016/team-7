package com.team7.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by jbeckman on 10/29/16.
 */
@Entity
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long pk_community;

    @JsonProperty("region")
    protected String region;

    @NotNull
    @JsonProperty("country")
    protected String country;

    public Community(String region, String country) {
        this.region = region;
        this.country = country;
    }
}
