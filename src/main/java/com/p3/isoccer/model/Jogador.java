package com.p3.isoccer.model;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.rest.API;
import org.json.JSONObject;

public class Jogador extends Employee {
    private String posicao;
    public Jogador()
    {
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
        json.put("aditional", getPosicao());
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
        json.put("aditional", getPosicao());
        try {
            api.update(json, url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void setPosicao(String posicao)
    {
        this.posicao = posicao;
    }
    public String getPosicao()
    {
        return this.posicao;
    }
}
