package com.p3.isoccer.model;

public class Employee {
    public String name, function, email, cpf, tel, aditional;
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

    public Employee() {

    }
}
