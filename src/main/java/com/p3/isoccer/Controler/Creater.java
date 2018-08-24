package com.p3.isoccer.Controler;

import com.p3.isoccer.model.*;
import com.p3.isoccer.rest.API;

import java.util.Scanner;

/**
 * Created by alunoic on 10/08/18.
 */
public class Creater {
    private API api;
    public Creater(API api){
        this.api = api;
    }

    public void createEmployee()
    {
        Scanner in = new Scanner(System.in);
        String aux;
        Employee e;
        System.out.print("Funcao: ");
        aux = in.nextLine();
        if(aux.equals("Medico")) {
            e = new Medico();
            e.setFunction(aux);
            System.out.print("CRM: ");
            aux = in.nextLine();
            ((Medico)e).setCrm(aux);
        }
        else if(aux.equals("Jogador"))
        {
            e = new Jogador();
            e.setFunction(aux);
            System.out.print("Posicao: ");
            aux = in.nextLine();
            ((Jogador) e).setPosicao(aux);
        }
        else if(aux.equals("Motorista")){
            e = new Motorista();
            e.setFunction(aux);
            System.out.print("Habilitacao: ");
            aux = in.nextLine();
            ((Motorista) e).sethabilitacao(aux);
        }
        else{
            e = new Employee();
            e.setFunction(aux);
        }

        System.out.print("Nome: ");
        aux = in.nextLine();
        e.setName(aux);


        System.out.print("Email: ");
        aux = in.nextLine();
        e.setEmail(aux);

        System.out.print("CPF: ");
        aux = in.nextLine();
        e.setCpf(aux);

        System.out.print("Telefone: ");
        aux = in.nextLine();
        e.setTel(aux);

        System.out.print("Salario: ");
        aux = in.nextLine();
        e.setSalario(Double.parseDouble(aux));

        e.create(this.api);
    }

    public void creteFan()
    {
        Scanner in = new Scanner(System.in);
        String aux;
        Fans e = new Fans();

        System.out.print("Nome: ");
        aux = in.nextLine();
        e.setName(aux);

        System.out.print("Endereco: ");
        aux = in.nextLine();
        e.setAddrs(aux);

        System.out.print("Email: ");
        aux = in.nextLine();
        e.setEmail(aux);

        System.out.print("CPF: ");
        aux = in.nextLine();
        e.setCpf(aux);

        System.out.print("Status: ");
        aux = in.nextLine();
        e.setStatus(aux);

        System.out.print("Contribuicao: ");
        aux = in.nextLine();
        e.setValue(Double.parseDouble(aux));

        e.create(this.api);
    }

    public void creteRecourse(){
        Scanner in = new Scanner(System.in);
        String aux;
        Recouses e;

        System.out.print("Tipo: ");
        aux = in.nextLine();
        if(aux.equals("Estadio")){
            e = new Estadio();
            e.setType(aux);


            System.out.print("Quantidade de Bnaheiros: ");
            aux = in.nextLine();
            ((Estadio)e).setWc(Integer.parseInt(aux));

            System.out.print("Quantidade de Lanchonetes: ");
            aux = in.nextLine();
            ((Estadio)e).setLanch(Integer.parseInt(aux));

            System.out.print("Capacidade Maxima: ");
            aux = in.nextLine();
            ((Estadio)e).setMaxCap(Integer.parseInt(aux));

        }
        else {
            e = new Recouses();
        }

        System.out.print("Quantidade: ");
        aux = in.nextLine();
        e.setQuant(Integer.parseInt(aux));

        if(e instanceof Estadio){
            ((Estadio)e).create(this.api);
            return;
        }
        e.create(this.api);
    }
}
