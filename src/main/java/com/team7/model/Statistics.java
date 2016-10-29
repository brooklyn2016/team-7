package com.team7.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by joonho on 10/29/16.
 */
@Entity
public class Statistics implements Comparable<Statistics> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long pk_statistics;

    @NotNull
    @JsonProperty("stat-year")
    protected int year;

    @NotNull
    @JsonProperty("stat-year")
    protected int quarter;

    @NotNull
    @JsonProperty("community-id")
    protected Long c_id;

    @ElementCollection(fetch = FetchType.EAGER)
    @JsonProperty("stat-vals")
    protected List<StatValTuple> statVals = new LinkedList<>();

    private int yearQuarter;


    public void setPk_statistics(Long pk_statistics) {
        this.pk_statistics = pk_statistics;
    }

    public List<StatValTuple> getStatVals() {
        return statVals;
    }

    public Long getPk_statistics() {
        return pk_statistics;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        setYearQuarter(year, quarter);
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        setYearQuarter(year, quarter);
    }

    public int getYearQuarter() {
        return yearQuarter;
    }

    public void setYearQuarter(int year, int quarter) {
        this.year = year;
        this.quarter = quarter;
        yearQuarter = year * 100 + quarter;
    }

    public Long getC_id() {
        return c_id;
    }

    public void setC_id(Long c_id) {
        this.c_id = c_id;
    }

    @Override
    public int compareTo(Statistics statistics) {
        return yearQuarter - statistics.getYearQuarter();
    }
}
