package com.p3.isoccer.model;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.rest.API;
import org.json.JSONObject;

public class CentrodeTreinamento extends recouses {
    public CentrodeTreinamento(String Type, int id, int quant)
    {
        super(Type, id, quant);
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
}
