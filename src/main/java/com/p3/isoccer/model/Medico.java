package com.p3.isoccer.model;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.rest.API;
import org.json.JSONObject;

public class Medico extends Employee {
    private String crm;
    public Medico(String name, String function, String email, String cpf, String tel, double salario, String crm)
    {
        super(name, function, email, cpf, tel, salario);
        this.crm = crm;
    }

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
        json.put("aditional", getCrm());
        try {
            api.create(json, url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
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
        json.put("aditional", getCrm());
        try {
            api.update(json, url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public void setCrm(String crm)
    {
        this.crm = crm;
    }
    public String getCrm()
    {
        return this.crm;
    }

}
