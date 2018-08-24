package com.p3.isoccer.model;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.rest.API;
import org.json.JSONObject;

public class Estadio extends recouses {

    private int wc, maxCap, lanch;

    public Estadio()
    {
    }


    public int getWc() {
        return wc;
    }

    public int getLanch() {
        return lanch;
    }

    public int getMaxCap() {
        return maxCap;
    }

    public void setWc(int wc) {
        this.wc = wc;
    }

    public void setMaxCap(int maxCap) {
        this.maxCap = maxCap;
    }
    public void setLanch(int lanch)
    {
        this.lanch = lanch;
    }
}
