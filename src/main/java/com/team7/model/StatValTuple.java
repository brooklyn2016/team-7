package com.team7.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.internal.NotNull;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

/**
 * Created by joonho on 10/29/16.
 */
@Embeddable
public class StatValTuple {

    @NotNull
    @JsonProperty("stat")
    protected String stat;

    @NotNull
    @JsonProperty("val")
    protected double val;

    @NotNull
    @JsonProperty("stat-id")
    protected Long stat_id;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public Long getPk_statistics() {
        return stat_id;
    }

    public void setPk_statistics(Long pk_statistics) {
        this.stat_id = pk_statistics;
    }
}
