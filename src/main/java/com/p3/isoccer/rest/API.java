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
        } catch (UnirestException e) {
            e.printStackTrace();
        }
    }
    public  boolean hasToken() {
        return !token.isEmpty();
    }
    public void createEmployee(Employee e) throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        JSONObject json = new JSONObject();
        json.put("name", e.name);
        json.put("function", e.function);
        json.put("email", e.email);
        json.put("cpf", e.cpf);
        json.put("tel", e.tel);
        json.put("aditional", e.aditional);
        json.put("salario", e.salario);
        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8000/employee/")
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").body(json).asJson();
        System.out.println(response.getStatus());
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
            emp.name = myj.getString("name");
            emp.aditional = myj.getString("aditional");
            emp.cpf = myj.getString("cpf");
            emp.email = myj.getString("email");
            emp.function = myj.getString("function");
            emp.salario = myj.getDouble("salario");
            emp.tel = myj.getString("tel");
            emp.setId(myj.getInt("id"));
            myemployyeslist.add(emp);
        }
        return myemployyeslist;
    }

    public void deleteEmployee(int id) throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        HttpResponse<JsonNode> response = Unirest.delete("http://localhost:8000/employee/" + id)
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").asJson();

    }
    public void detailEmployee(int id) throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        HttpResponse<JsonNode> response = Unirest.put("http://localhost:8000/employee/" + id)
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").asJson();

        JSONObject json = response.getBody().getObject();
        String a = json.getString("name");
        System.out.println("FUNCAO:" + json.getString("function"));
        System.out.println("NOME:" + json.getString("name"));
        System.out.println("CPF: " + json.getString("cpf"));
        System.out.println("EMAIL: " + json.getString("email"));
        System.out.println("TEL: " + json.getString("tel"));
        System.out.println("SALARIO: " + json.getDouble("salario"));

    }



    public void createFans(Fans e) throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        JSONObject json = new JSONObject();
        json.put("name", e.name);
        json.put("adress", e.addrs);
        json.put("email", e.email);
        json.put("cpf", e.cpf);
        json.put("value", e.value);
        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8000/fans/")
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").body(json).asJson();
        System.out.println(response.getStatus());
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
            emp.name = myj.getString("name");
            emp.cpf = myj.getString("cpf");
            emp.email = myj.getString("email");
            emp.addrs = myj.getString("adress");
            emp.value = myj.getDouble("value");
            emp.setId(myj.getInt("id"));
            myemployyeslist.add(emp);
        }
        return myemployyeslist;
    }
    public void deleteFans(int id) throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        HttpResponse<JsonNode> response = Unirest.delete("http://localhost:8000/fans/" + id)
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").asJson();
    }
    public void retriveFans(Fans e) throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        JSONObject json = new JSONObject();
        json.put("name", e.name);
        json.put("adress", e.addrs);
        json.put("email", e.email);
        json.put("cpf", e.cpf);
        json.put("value", e.value);
        HttpResponse<JsonNode> response = Unirest.put("http://localhost:8000/fans/" + e.getId())
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").body(json).asJson();
        System.out.println(response.getStatus());
    }
    public void createRecourses(recouses e) throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        JSONObject json = new JSONObject();
        json.put("type", e.Type);
        json.put("max_ocupation ", e.max_ocupatio);
        json.put("wc", e.wc);
        json.put("lanch ", e.lach);
        HttpResponse<JsonNode> response = Unirest.post("http://localhost:8000/recourse/")
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").body(json).asJson();
        System.out.println(response.getStatus());
    }

    public ArrayList<recouses> createRecourse()throws UnirestException {
        if (token.isEmpty()) {
            throw new RuntimeException("Not Authenticated");
        }
        HttpResponse<JsonNode> response = Unirest.get("http://localhost:8000/recourse/")
                .header("Authorization", "JWT " + token)
                .header("Content-Type", "application/json").asJson();
        System.out.println(response.getStatus());

        JSONArray n= response.getBody().getArray();
        ArrayList<recouses> myemployyeslist = new ArrayList<>();
        recouses emp;
        for(int i = 0; i < n.length(); i++)
        {
            JSONObject myj = n.getJSONObject(i);
            emp =  new recouses();
            emp.Type = myj.getString("type");
            emp.max_ocupatio = myj.getInt("max_ocupation ");
            emp.wc = myj.getInt("wc ");
            emp.ad = myj.getInt("lanch");

            myemployyeslist.add(emp);
        }
        return myemployyeslist;
    }
}
