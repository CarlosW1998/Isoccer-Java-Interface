package com.p3.isoccer.model;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.rest.API;
import org.json.JSONObject;

public class Employee {
    private String name;
    private String function;
    private String email;
    private String cpf;
    private String tel;
    private int id;
    public double salario;

    public Employee(){
    }

    public void delete(API api)
    {
        String url = "http://localhost:8000/employee/" + getId();
        try {
            api.delete(url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
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
        try {
            api.update(json, url);
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }

    public String toString(){
        return "Id: "  + getId() + " | Name" + getName() + " | Funcao: " + getFunction() + "\n";
    }


    public void setId(int i) {
        this.id = i;
    }
    public void setName(String Name) {
        this.name = Name;
    }
    public void setFunction(String Function) {
        this.function = Function;
    }
    public void setEmail(String Email) {
        this.email = Email;
    }
    public void setCpf(String Cpf) {
        this.cpf = Cpf;
    }
    public void setTel(String Tel) {
        this.tel = Tel;
    }
    public void setSalario(double Salario) {
        this.salario = Salario;
    }

    public int getId() {
        return  this.id;
    }
    public String getName() {
        return  this.name;
    }
    public String getFunction() {
        return  this.function;
    }
    public String getEmail() {
        return  this.email;
    }
    public String getCpf() {
        return  this.cpf;
    }
    public String getTel() {
        return  this.tel;
    }
    public double getSalario() {
        return  this.salario;
    }
}
