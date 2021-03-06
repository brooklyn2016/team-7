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

    @NotNull
    @JsonProperty("name")
    protected String name;

    public Community() {};

    public Community(String region, String country, String name) {
        this.region = region;
        this.country = country;
        this.name = name;
    }

    public Long getPk_community() {
        return pk_community;
    }

    public void setPk_community(Long pk_community) {
        this.pk_community = pk_community;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Community community = (Community) o;

        if (pk_community != null ? !pk_community.equals(community.pk_community) : community.pk_community != null)
            return false;
        if (region != null ? !region.equals(community.region) : community.region != null) return false;
        if (!country.equals(community.country)) return false;
        return name.equals(community.name);

    }

    @Override
    public int hashCode() {
        int result = pk_community != null ? pk_community.hashCode() : 0;
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + country.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }
}
