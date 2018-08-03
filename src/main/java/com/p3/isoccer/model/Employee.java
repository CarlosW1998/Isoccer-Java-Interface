package com.p3.isoccer.model;

public class Employee {
    public String name, function, email, cpf, tel, aditional;
    private int id;
    public double salario;

    public Employee(String name, String function, String email, String cpf, String tel, String aditional, double salario) {
        this.name = name;
        this.function = function;
        this.email = email;
        this.cpf = cpf;
        this.tel = tel;
        this.aditional = aditional;
        this.salario = salario;
    }
    public void setId(int i) {
        this.id = i;
    }
    public int getId() {
        return  this.id;
    }
    public void meybeprint()
    {
        if(this.function.equals("Medico"))
        {
            System.out.println("CRM: " + this.aditional);
        }
        if(this.function.equals("Jogador"))
        {
            System.out.println("POSICAO: " + this.aditional);
        }
        if(this.function.equals("Motorista"))
        {
            System.out.println("HABILITACAO: " + this.aditional);
        }
    }
    public Employee() {

    }
}
