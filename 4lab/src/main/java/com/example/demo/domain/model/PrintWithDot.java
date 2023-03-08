package com.example.demo.domain.model;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PrintWithDot implements Printable{
    public void print(String message){
        log.info(message + ".");
    }
}
