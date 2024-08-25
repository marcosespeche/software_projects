package com.marcosespeche.services;

import com.marcosespeche.entities.Member;
import com.marcosespeche.events.Event;
import com.marcosespeche.events.EventType;
import com.marcosespeche.events.MemberEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Slf4j
@Component
public class MemberEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    @Value("${topic.member.name:members}")
    private String topic;

    public void publish(Member entity, EventType eventType) {
            MemberEvent event = MemberEvent.builder().build();
            event.setData(entity);
            event.setEventType(eventType);
            event.setId(UUID.randomUUID().toString());
            event.setDate(new Date());

            this.producer.send(topic, event);

            log.info("Event sent .... with id={}, data={}",
                    event.getId(),
                    event.getData().toString());
    }
}
