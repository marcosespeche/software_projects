package com.marcosespeche.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event <E> {

    private String id;

    private Date date;

    private EventType eventType;

    private E data;
}
