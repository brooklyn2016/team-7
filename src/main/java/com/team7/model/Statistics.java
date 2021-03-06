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
    @Column(name="c_id")
    protected Long cId;

    @ElementCollection(fetch = FetchType.EAGER)
    @JsonProperty("stat-vals")
    protected List<StatValTuple> statVals = new LinkedList<>();

    private int yearQuarter;

    public Statistics() {};

    public Statistics(int year, int quarter, long c_id) {
        setYear(year);
        setQuarter(quarter);
        setcId(c_id);
    }

    public void setPk_statistics(Long pk_statistics) {
        this.pk_statistics = pk_statistics;
    }

    public List<StatValTuple> getStatVals() {
        return statVals;
    }

    public void setStatVals(List<StatValTuple> statVals) {
        this.statVals = statVals;
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

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    @Override
    public int compareTo(Statistics statistics) {
        return yearQuarter - statistics.getYearQuarter();
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "pk_statistics=" + pk_statistics +
                ", year=" + year +
                ", quarter=" + quarter +
                ", c_id=" + cId +
                ", statVals=" + statVals +
                ", yearQuarter=" + yearQuarter +
                '}';
    }
}
