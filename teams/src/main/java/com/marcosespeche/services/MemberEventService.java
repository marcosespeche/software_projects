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
        MemberEvent memberEvent = (MemberEvent) event;
        log.info("Member Event received with Id={}, data={}",
                memberEvent.getId(),
                memberEvent.getData().toString());

        try {
            handleEvent(memberEvent);
        } catch (Exception e) {
            log.error("Error processing event: Id={}, type={}, data={}",
                    memberEvent.getId(),
                    memberEvent.getEventType(),
                    memberEvent.getData(), e);
        }
    }

    private void handleEvent(MemberEvent memberEvent) throws Exception {
        Member memberData = memberEvent.getData();

        switch (memberEvent.getEventType()) {
            case CREATED:
                memberService.save(memberData);
                break;
            case UPDATED:
                memberService.update(memberData.getId(), memberData);
                break;
            case DELETED:
                memberService.delete(memberData.getId());
                break;
            default:
                throw new UnsupportedOperationException("Event type not supported: " + memberEvent.getEventType());
        }
    }
}