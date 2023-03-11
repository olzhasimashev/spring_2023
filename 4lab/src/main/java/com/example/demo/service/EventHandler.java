package com.example.demo.service;

import com.example.demo.domain.event.DefaultEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventHandler {
    @EventListener
    public void process(DefaultEvent event) {
        log.info("event received: " + event);
    }
}
