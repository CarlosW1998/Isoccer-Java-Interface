package com.p3.isoccer.model;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.rest.API;
import org.json.JSONObject;

public class Fans {
    private String name, addrs, cpf, email, status;
    private int id;
    private double value;

    public Fans(String nome, String addrs, String cpf, String email, String Status, int id, double value)
    {
        this.name = nome;
        this.addrs = addrs;
        this.cpf = cpf;
        this.email = email;
        this.status = Status;
        this.id = id;
        this.value = value;
    }

    public void delete(API api)
    {
        String url = "http://localhost:8000/fans/" + getId();
        try {
            api.delete(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void create(API api)
    {
        String url = "http://localhost:8000/fans/";
        JSONObject json = new JSONObject();
        json.put("name", getName());
        json.put("function", getAddrs());
        json.put("email", getEmail());
        json.put("cpf", getCpf());
        json.put("tel", getValue());
        try {
            api.create(json, url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
    public void update(API api)
    {
        String url = "http://localhost:8000/fans/";
        JSONObject json = new JSONObject();
        json.put("name", getName());
        json.put("function", getAddrs());
        json.put("email", getEmail());
        json.put("cpf", getCpf());
        json.put("tel", getValue());
        try {
            api.update(json, url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }


    public void setId(int i) {
        this.id = i;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAddrs(String addrs) {
        this.addrs = addrs;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getId() {
        return this.id;
    }

    public double getValue() {
        return this.value;
    }

    public String getAddrs() {
        return this.addrs;
    }

    public String getCpf() {
        return this.cpf;
    }

    public String getEmail() {
        return this.email;
    }

    public String getName() {
        return this.name;
    }

    public String getStatus() {
        return this.status;
    }
}
