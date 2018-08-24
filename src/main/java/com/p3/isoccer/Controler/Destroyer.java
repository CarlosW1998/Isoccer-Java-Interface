package com.p3.isoccer.Controler;

import com.p3.isoccer.model.Employee;
import com.p3.isoccer.model.Fans;
import com.p3.isoccer.model.Recouses;
import com.p3.isoccer.rest.API;

public class Destroyer {
    private API api;
    public Destroyer(API api){
        this.api = api;
    }
    public void destroyEmploye(int id){
        Employee e = new Employee();
        e.setId(id);
        e.delete(this.api);
    }
    public void destroyFan(int id){
        Fans e = new Fans();
        e.setId(id);
        e.delete(this.api);
    }
    public void destroyRecourse(int id){
        Recouses e = new Recouses();
        e.setId(id);
        e.delete(this.api);
    }
}
