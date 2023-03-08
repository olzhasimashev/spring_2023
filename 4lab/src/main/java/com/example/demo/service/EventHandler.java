package com.example.demo.service;

import com.example.demo.domain.event.AccountCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventHandler {
    @EventListener
    public void process(AccountCreatedEvent event) {
        log.info("event received: " + event);
    }
}
