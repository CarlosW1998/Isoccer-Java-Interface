package com.p3.isoccer.rest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;
import com.p3.isoccer.model.*;
import org.json.JSONArray;
import org.json.JSONObject;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class API {
    private String token = "";

    public void auth(String username, String password) {
        JSONObject json = new JSONObject();
        json.put("username", username);
        json.put("password", password);
        HttpResponse<JsonNode> response = null;
        try {
            response = Unirest.post("http://localhost:8000/api-token-auth/")
                    .header("Content-Type", "application/json").body(json).asJson();
            if (response.getStatus() != 200) {
                throw new RuntimeException("Credenciais incorretas");
            }
            token = response.getBody().getObject().getString("token");

        } catch (Exception e) {

            System.out.println("Erro ao tentar acessar as credenciais");
        }
    }
    public  boolean hasToken() {
        return !token.isEmpty();
    }
    private void mensagem(int code)
    {
        if(code == 200){
            System.out.println("Operaçao Concluida Com Sucesso");
        }
        else if(code == 201) {
            System.out.println("Criação relizada com sucesso");
        }
        else if(code == 400) {
            System.out.println("Dados invaldos");
        }
        else{
            System.out.println("Ocorrue um Eror na Operação");
        }
    }

    public void create(JSONObject json, String Url) throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        HttpResponse<JsonNode> response = Unirest.post(Url)
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").body(json).asJson();
        mensagem(response.getStatus());
    }

    public void update(JSONObject json, String Url) throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        HttpResponse<JsonNode> response = Unirest.put(Url)
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").body(json).asJson();
        System.out.println(response.getStatus());
    }
    public JSONObject detail(JSONObject json, String Url) throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        HttpResponse<JsonNode> response = Unirest.put(Url)
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").body(json).asJson();

        JSONObject myj = response.getBody().getObject();
        mensagem(response.getStatus());
        return myj;
    }

    public void delete(String Url) throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        HttpResponse<JsonNode> response = Unirest.delete(Url)
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").asJson();
        mensagem(response.getStatus());

    }

    public ArrayList<Employee> getEmployee()throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8000/employee/")
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").asJson();
        System.out.println(response.getStatus());

        JSONArray n= response.getBody().getArray();
        ArrayList<Employee> myemployyeslist = new ArrayList<>();
        Employee emp;
        for(int i = 0; i < n.length(); i++)
        {
            JSONObject myj = n.getJSONObject(i);
            emp =  new Employee();
            emp.setId(myj.getInt("id"));
            emp.setName(myj.getString("name"));
            emp.setFunction(myj.getString("function"));
            emp.setEmail(myj.getString("email"));
            emp.setCpf(myj.getString("cpf"));
            emp.setTel(myj.getString("tel"));
            emp.setSalario(myj.getDouble("salario"));

            myemployyeslist.add(emp);
        }
        return myemployyeslist;
    }

    public ArrayList<Fans> getFans()throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8000/fans/")
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").asJson();
        System.out.println(response.getStatus());

        JSONArray n= response.getBody().getArray();
        ArrayList<Fans> myemployyeslist = new ArrayList<>();
        Fans emp;
        for(int i = 0; i < n.length(); i++)
        {
            JSONObject myj = n.getJSONObject(i);
            emp =  new Fans();
            emp.setId(myj.getInt("id"));
            emp.setName(myj.getString("name"));
            emp.setAddrs(myj.getString("adress"));
            emp.setCpf(myj.getString("cpf"));
            emp.setEmail(myj.getString("email"));
            emp.setValue(myj.getDouble("value"));

            myemployyeslist.add(emp);
        }
        return myemployyeslist;
    }


    public ArrayList<Recouses> getRecourse()throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8000/recourse/")
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").asJson();
        System.out.println(response.getStatus());

        JSONArray n= response.getBody().getArray();
        ArrayList<Recouses> myemployyeslist = new ArrayList<>();
        Recouses emp;
        for(int i = 0; i < n.length(); i++)
        {
            JSONObject a = n.getJSONObject(i);
            emp = new Recouses();
            emp.setType(a.getString("Type"));
            emp.setId(a.getInt("id"));
            emp.setQuant(a.getInt("quant"));

            myemployyeslist.add(emp);
        }
        return myemployyeslist;
    }
}
