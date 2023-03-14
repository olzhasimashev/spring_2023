package com.example.demo.domain.model;

public class MyGreeting {
    Printable printer;

    public MyGreeting(Printable printer){
        this.printer = printer;
    }
    public void print(String message){
        printer.print(message);
    }
}
