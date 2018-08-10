package com.p3.isoccer.model;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.rest.API;
import org.json.JSONObject;

public class Estadio extends recouses {

    private int wc, maxCap, lanch;

    public Estadio(String Type, int id, int quant, int wc, int maxCap, int lanch)
    {
        super(Type, id, quant);
        this.wc = wc;
        this.lanch = lanch;
        this.maxCap = maxCap;
    }
    public void create(API api)
    {
        String url = "http://localhost:8000/recourse/";
        JSONObject json = new JSONObject();
        json.put("Type", getType());
        json.put("quant", getQuant());

        try {
            api.create(json, url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
    public void update(API api)
    {
        String url = "http://localhost:8000/recourse/";
        JSONObject json = new JSONObject();
        json.put("Type", getType());
        json.put("quant", getQuant());

        try {
            api.update(json, url);
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
