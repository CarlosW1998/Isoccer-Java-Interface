package com.p3.isoccer.model;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.rest.API;
import org.json.JSONObject;

public class Estadio extends Recouses {

    private int wc, maxCap, lanch;

    public Estadio()
    {
    }

    @Override
    public void create(API api){
        String url = "http://localhost:8000/recourse/";
        JSONObject json = new JSONObject();
        json.put("Type", getType());
        json.put("max_ocupation", getQuant());
        json.put("wc", getWc());
        json.put("lanch", getLanch());

        try {
            api.create(json, url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
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
