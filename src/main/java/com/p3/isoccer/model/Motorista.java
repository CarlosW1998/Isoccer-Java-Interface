package com.p3.isoccer.model;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.rest.API;
import org.json.JSONObject;

public class Motorista extends Employee {
    private String habilitacao;

    public Motorista() {
    }

    @Override
    public void create(API api)
    {
        String url = "http://localhost:8000/employee/";
        JSONObject json = new JSONObject();
        json.put("name", getName());
        json.put("function", getFunction());
        json.put("email", getEmail());
        json.put("cpf", getCpf());
        json.put("tel", getTel());
        json.put("salario", getSalario());
        json.put("aditional", gethabilitacao());
        try {
            api.create(json, url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void update(API api)
    {
        String url = "http://localhost:8000/employee/";
        JSONObject json = new JSONObject();
        json.put("name", getName());
        json.put("function", getFunction());
        json.put("email", getEmail());
        json.put("cpf", getCpf());
        json.put("tel", getTel());
        json.put("salario", getSalario());
        json.put("aditional", gethabilitacao());
        try {
            api.update(json, url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void sethabilitacao(String crm)
    {
        this.habilitacao = habilitacao;
    }
    public String gethabilitacao()
    {
        return this.habilitacao;
    }
}
