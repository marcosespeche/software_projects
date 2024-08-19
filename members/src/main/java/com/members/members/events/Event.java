package com.members.members.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Event <E> {

    private String id;

    private Date date;

    private EventType eventType;

    private E data;
}
