package com.members.members.services;

import com.members.members.Events.Event;
import com.members.members.Events.EventType;
import com.members.members.entities.Member;
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

    public void publish(Member entity, EventType eventType) {
            Event<Member> event = Event.<Member>builder()
                    .data(entity)
                    .date(new Date())
                    .id(UUID.randomUUID().toString())
                    .eventType(eventType).build();


        String topic = "member:created";
        this.producer.send(topic, event);
    }
}
