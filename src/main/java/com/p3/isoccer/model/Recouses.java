package com.p3.isoccer.model;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.rest.API;
import org.json.JSONObject;

public class Recouses {
    private  String Type;
    private int id, quant;

    public Recouses()
    {
    }

    public String toString() {
        return "Id: " + getId() + " | Type: " + getType()  + " | Quantidade: " + getQuant();
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

    public void create(API api){
        String url = "http://localhost:8000/recourse/";
        JSONObject json = new JSONObject();
        json.put("Type", getType());
        json.put("max_ocupation", getQuant());

        try {
            api.create(json, url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
    public void update(API api){
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
