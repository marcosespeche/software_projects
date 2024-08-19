package com.members.members.services;

import com.members.members.entities.Role;
import com.members.members.events.Event;
import com.members.members.events.EventType;
import com.members.members.events.RoleEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class RoleEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.role.name:roles}")
    private String topic;

    public void publish(Role role, EventType eventType){
        RoleEvent event = RoleEvent.builder().build();
        event.setData(role);
        event.setEventType(eventType);
        event.setId(UUID.randomUUID().toString());
        event.setDate(new Date());

        producer.send(topic, event);
    }
}
