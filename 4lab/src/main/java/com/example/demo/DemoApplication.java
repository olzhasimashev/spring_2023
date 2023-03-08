package com.example.demo;

import com.example.demo.domain.model.MyGreeting;
import com.example.demo.domain.model.PrintWithComma;
import com.example.demo.domain.model.PrintWithDot;
import com.example.demo.domain.model.PrintWithSemicolon;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        MyGreeting g = new MyGreeting(new PrintWithSemicolon());
        g.print("test");
    }

}
