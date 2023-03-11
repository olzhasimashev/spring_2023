package com.example.demo.domain.event;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class DefaultEvent {
    String aggregateObjectType;
    String aggregateObjectId;
    String messagePayload;
    LocalDateTime emittedDate;
}
