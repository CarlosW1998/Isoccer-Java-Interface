package com.p3.isoccer;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.p3.isoccer.model.Employee;
import com.p3.isoccer.model.Fans;
import com.p3.isoccer.model.recouses;
import com.p3.isoccer.rest.API;

import java.util.ArrayList;

public class Dysplay {
    public void dysplayEmployee(API api) throws UnirestException {
        ArrayList<Employee> myEmployes = api.getEmployee();
        myEmployes.forEach((e) -> System.out.println(e.getId() + "; " + e.getFunction() + "; " + e.getName() + "; " + e.getEmail()));
    }
    public void dysplayrecourses(API api) throws UnirestException {
        ArrayList<recouses> myRecourses = api.getRecourse();
        myRecourses.forEach((a) -> System.out.println(a.getId() + "; " + a.getType()));
    }
    public  void dysplayFans(API api) throws UnirestException {
        ArrayList<Fans> myFans = api.getFans();
        myFans.forEach((a) -> System.out.println(a.getId() + "; " + a.getName() + "; " + a.getStatus()));
    }
}
