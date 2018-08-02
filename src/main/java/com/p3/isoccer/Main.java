package com.p3.isoccer;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.model.Employee;
import com.p3.isoccer.rest.API;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Bem-vindo ao isoccer");
        System.out.println("Vamos autenticar.\nFavor inserir seu usuário:");
        String username = s.nextLine();
        System.out.println("Agora sua senha:");
        String password = s.nextLine();
        System.out.println("Tentando autenticar...");
        API api = new API();
        api.auth(username, password);
        System.out.println("Autenticação realizada com sucesso.");
        System.out.println("\n\nCriando um funcionário:\n");
        Employee e = new Employee();
        System.out.println("Insira o nome:");
        e.name = s.nextLine();
        System.out.println("Insira a função:");
        e.function = s.nextLine();
        System.out.println("Insira o email:");
        e.email = s.nextLine();
        System.out.println("Insira o CPF");
        e.cpf = s.nextLine();
        System.out.println("Insira o telefone:");
        e.tel = s.nextLine();
        System.out.println("Insira adicional:");
        e.aditional = s.nextLine();
        System.out.println("Insira o salario, casas decimais separadas por virgula:");
        e.salario = Double.parseDouble(s.nextLine());
        System.out.println("Estamos tentando criar o funcionário...");
        try {
            api.createEmployee(e);
            System.out.println("Usuário criado com sucesso");
        } catch (UnirestException e1) {
            e1.printStackTrace();
        }
        try {
            Unirest.shutdown();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
