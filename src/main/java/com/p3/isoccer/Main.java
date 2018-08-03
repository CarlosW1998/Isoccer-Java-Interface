package com.p3.isoccer;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.model.*;
import com.p3.isoccer.rest.API;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void addEmployee(API api)
    {
        Scanner s = new Scanner(System.in);
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
            System.out.println("Funcionário criado com sucesso");
        } catch (UnirestException e1) {
            e1.printStackTrace();
        }
    }

    public static void listEmployee(API api) throws UnirestException {
        ArrayList<Employee> myEmployess = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int option;
        final int[] index = { 0 };
        try{
            myEmployess = api.getEmployee();
        } catch (UnirestException e1) {
            e1.printStackTrace();
        }
        myEmployess.forEach(e -> {
            System.out.println("ID: " + (index[0]) + " Nome: " + e.name + " Funcao: " + e.function);
            index[0]++;
        });
        if(myEmployess.size() == 0) {
            System.out.println("Nenhum Empregado no Sistema");
            return;
        }
        System.out.println("Para deletar um Empregado Digite 1 e seu ID digite\nPara informacoes detalhadas digite 2 e seu ID\nPara sair digite 0");
        option = s.nextInt();
        if(option == 1)
        {
            option = s.nextInt();

            api.deleteEmployee(myEmployess.get(option).getId());

            return;
        }
        if(option == 2)
        {
            option = s.nextInt();
            Employee selected = myEmployess.get(option);
            System.out.println("FUNCAO:" + selected.function);
            System.out.println("NOME:" + selected.name);
            System.out.println("CPF: " + selected.cpf);
            System.out.println("EMAIL: " + selected.email);
            System.out.println("TEL: " + selected.tel);
            System.out.println("SALARIO: " + selected.salario);
        }


    }
    public static void createFan(API api)
    {
        Fans e = new Fans();
        Scanner s = new Scanner(System.in);
        System.out.println("Insira o nome:");
        e.name = s.nextLine();
        System.out.println("Insira o Endereco:");
        e.addrs = s.nextLine();
        System.out.println("Insira o CPF:");
        e.cpf = s.nextLine();
        System.out.println("Insira o Email:");
        e.email = s.nextLine();
        System.out.println("Insira a Contribuicao:");
        e.value = Double.parseDouble(s.nextLine());
        System.out.println("Estamos tentando criar o torcedor...");
        try {
            api.createFans(e);
        } catch (UnirestException e1) {
            e1.printStackTrace();
        }
    }
    public static  void detailFan(API api) throws UnirestException {
        ArrayList<Fans> myfans = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        int option;
        final int[] index = { 0 };
        try{
            myfans = api.getFans();
        } catch (UnirestException e1) {
            e1.printStackTrace();
        }
        myfans.forEach(e -> {
            System.out.println("ID: " + (index[0]) + " Nome: " + e.name);
            index[0]++;
        });
        if(myfans.size() == 0) {
            System.out.println("Nenhum Torcedor no Sistema");
            return;
        }
        System.out.println("Para deletar um Torcedor Digite 1 e seu ID digite\nPara informacoes detalhadas digite 2 e seu ID\nPara setar o valor da contribuicao digite 3 o ID e a contribuicao\nPara sair digite 0");
        option = s.nextInt();
        if(option == 1)
        {
            option = s.nextInt();

            api.deleteFans(myfans.get(option).getId());

            return;
        }
        if(option == 2)
        {
            option = s.nextInt();
            Fans selected = myfans.get(option);
            System.out.println("NOME:" + selected.name);
            System.out.println("CPF: " + selected.cpf);
            System.out.println("EMAIL: " + selected.email);
            System.out.println("ENDERECO: " + selected.addrs);
            System.out.println("CONTRIBUICAO: " + selected.value);
        }
        if (option == 3){
            option = s.nextInt();
            s.nextLine();
            double k = Double.parseDouble(s.nextLine());
            Fans selected = myfans.get(option);
            selected.value = option;
            api.retri
        }veFans(selected);

    }
    public static void createFan(API api)
    {
        Fans e = new recouses();
        Scanner s = new Scanner(System.in);
        System.out.println("Insira o Typo:");
        e.name = s.nextLine();
        System.out.println("Insira o Endereco:");
        e.addrs = s.nextLine();
        System.out.println("Insira o CPF:");
        e.cpf = s.nextLine();
        System.out.println("Insira o Email:");
        e.email = s.nextLine();
        System.out.println("Insira a Contribuicao:");
        e.value = Double.parseDouble(s.nextLine());
        System.out.println("Estamos tentando criar o torcedor...");
        try {
            api.createFans(e);
        } catch (UnirestException e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String[] args) throws UnirestException {
        Scanner s = new Scanner(System.in);
        API api = new API();
        int option;
        System.out.println("Bem-vindo ao isoccer");
        while(true)
        {
            System.out.println("Vamos autenticar.\nFavor inserir seu usuário:");
            String username = s.nextLine();
            System.out.println("Agora sua senha:");
            String password = s.nextLine();
            System.out.println("Tentando autenticar...");
            api.auth(username, password);
            while(api.hasToken())
            {
                System.out.println("Digite 1 para Adicionar um Funcionario");
                System.out.println("Digite 2 para Listar os Funcionarios");
                System.out.println("Digite 3 para Adicionar um Fan");
                System.out.println("Digite 4 para Listar os Fans");
                option = s.nextInt();
                if(option == 1) addEmployee(api);
                if(option == 2) listEmployee(api);
                if(option == 3) createFan(api);
                if(option == 4) detailFan(api);
                if(option == 5) detailFan(api);
            }
        }

    }
}
