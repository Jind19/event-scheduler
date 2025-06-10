package com.scheduler;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Event {
    ///Fields, Variables
    private final String name;
    private final LocalDateTime startDateTime;
    private final ZoneId zoneId;
    private EventStatus status;

    public Event(String name, LocalDateTime startDateTime, ZoneId zoneId) {
        this.name = name;
        this.startDateTime = startDateTime;
        this.zoneId = zoneId;
        this.status = EventStatus.SCHEDULED;
    }

    public void updateStatus() {
        ZonedDateTime eventStart = startDateTime.atZone(zoneId);
        ZonedDateTime now = ZonedDateTime.now(zoneId);

        if(now.isAfter(eventStart.plusHours(2))){
            status = EventStatus.COMPLETED;
        } else if (now.isAfter(eventStart)) {
            status = EventStatus.ONGOING;
        }
    }

    public void printDetails() {
        ZonedDateTime zonedStart = startDateTime.atZone(zoneId);
        System.out.println("Event: " + name);
        System.out.println("Starts at: " + zonedStart.format(DateTimeFormatter.RFC_1123_DATE_TIME));
        System.out.println("Status: " + status);
    }

    //getters
    public EventStatus getStatus() {
        return status;
    }

    public ZonedDateTime getZonedStart() {
        return startDateTime.atZone(zoneId);
    }

}
