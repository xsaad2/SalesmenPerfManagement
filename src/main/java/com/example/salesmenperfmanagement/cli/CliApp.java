//TODO : fix the shell circular dependency Problem

/* package com.example.salesmenperfmanagement.cli;

import com.example.salesmenperfmanagement.entities.SalesMan;
import com.example.salesmenperfmanagement.repositories.SalesManRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;


@ShellComponent
public class CliApp {

    @Autowired
    private SalesManRepo salesManRepo;

    @ShellMethod("adds")
    public String addSalesman(SalesMan salesman){
        salesManRepo.save(salesman);
        return "Salesman added";
    }

    @ShellMethod("gets")
    public SalesMan getSalesman(Integer sid){
        return salesManRepo.findById(sid).get();
    }
    @ShellMethod
    public Integer add(Integer a, Integer b){
        return a+b;
    }
}
*/



