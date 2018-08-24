package com.p3.isoccer;

import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.Controler.Creater;
import com.p3.isoccer.Controler.Dysplay;
import com.p3.isoccer.model.*;
import com.p3.isoccer.rest.API;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {



    public static void main(String[] args) throws UnirestException {
        Scanner s = new Scanner(System.in);
        API api = new API();
        int option;
        Dysplay myDysplay = new Dysplay();
        Creater myCreater = new Creater(api);
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
                System.out.println("Tecle 1 para Listar os recursos-");
                System.out.println("Tecke 2 para Listar os Funcionarios");
                System.out.println("Tecke 3 para Listar os fans");
                System.out.println("Tecke 4 para Listar adicionar um Funcionario");
                System.out.println("Tecke 5 para Listar adicionar um torcedor");
                System.out.println("Tecke 6 para Listar adicionar um recurso");
                System.out.println("-1 para sair");

                option = s.nextInt();
                if(option == 1){
                    myDysplay.dysplayrecourses(api);
                }
                else if(option == 2){
                    myDysplay.dysplayEmployee(api);
                }
                else if(option == 3) {
                    myDysplay.dysplayFans(api);
                }
                else if(option == 4) {
                    myCreater.createEmployee();
                }
                else if(option == 5){
                    myCreater.creteFan();
                }
                else if(option == 6){
                    myCreater.creteRecourse();
                }
                if(option == -1){break;};
            }
        }

    }
}
