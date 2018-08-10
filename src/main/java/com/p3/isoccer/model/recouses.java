package com.p3.isoccer.model;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.rest.API;

public class recouses {
    private  String Type;
    private int id, quant;

    public recouses(String Type, int id, int quant)
    {
        this.id = id;
        this.Type = Type;
        this.quant = quant;
    }

    public void delete(API api)
    {
        String url = "http://localhost:8000/recourse/" + getId();
        try {
            api.delete(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setQuant(int quant) {
        this.quant = quant;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public int getId() {
        return this.id;
    }

    public int getQuant() {
        return this.quant;
    }

    public String getType() {
        return Type;
    }
}
