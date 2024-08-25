package com.marcosespeche.events;

import lombok.Data;

import java.util.Date;

@Data
public class Event <T>{

    private EventType eventType;

    private Date date;

    private T data;

    private String id;
}
