package com.p3.isoccer.rest;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.model.Employee;
import org.json.JSONObject;

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
}
