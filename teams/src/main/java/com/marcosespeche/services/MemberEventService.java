package com.marcosespeche.services;

import com.marcosespeche.events.MemberEvent;
import com.marcosespeche.events.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MemberEventService {

    @KafkaListener(
            topics = "${topic.member.name:members}",
            containerFactory = "concurrentKafkaListenerContainerFactory",
            groupId = "group1"
    )
    public void receiveEvent(Event<?> event) {
        if (event.getClass().isAssignableFrom(MemberEvent.class)) {
            MemberEvent memberEvent = (MemberEvent) event;
            log.info("Received Member event .... with Id={}, data={}",
                    memberEvent.getId(),
                    memberEvent.getData().toString());
        }
    }
}
