package com.members.members.services;

import com.members.members.events.Event;
import com.members.members.events.EventType;
import com.members.members.entities.Member;
import com.members.members.events.MemberEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class MemberEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.customer.name:customers}")
    private String topic;

    public void publish(Member entity, EventType eventType) {
            MemberEvent event = MemberEvent.builder().build();
            event.setData(entity);
            event.setEventType(eventType);
            event.setId(UUID.randomUUID().toString());
            event.setDate(new Date());

            this.producer.send(topic, event);
    }
}
