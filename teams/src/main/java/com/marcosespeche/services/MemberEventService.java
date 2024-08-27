package com.marcosespeche.services;

import com.marcosespeche.entities.Member;
import com.marcosespeche.events.MemberEvent;
import com.marcosespeche.events.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MemberEventService {

    @Autowired
    private MemberService memberService;

    @KafkaListener(
            topics = "${topic.member.name:members}",
            containerFactory = "concurrentKafkaListenerContainerFactory",
            groupId = "group1"
    )
    public void receiveEvent(Event<Member> event) throws Exception {
        if (!event.getClass().isAssignableFrom(MemberEvent.class)) return;
        try {
            MemberEvent memberEvent = (MemberEvent) event;
            log.info("Received member event with Id={}, data={}",
                    memberEvent.getId(),
                    memberEvent.getData().toString());

            switch (event.getEventType()) {
                case CREATED:
                    memberService.save(event.getData());
                    break;
                case UPDATED:
                    memberService.update(event.getData().getId(), event.getData());
                    break;
                case DELETED:
                    memberService.delete(event.getData().getId());
                    break;
            }
        } catch (Exception e){
            throw new Exception("Error receiving event: " + e.getMessage(), e);
        }

    }
}
