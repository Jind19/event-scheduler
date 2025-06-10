package com.scheduler;

import org.junit.jupiter.api.Test;
import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

public class EventTest {

    @Test
    void testStatusTransition() {
        LocalDateTime twoHoursAgo = LocalDateTime.now().minusHours(2).minusMinutes(10);
        Event event = new Event("Old Event", twoHoursAgo, ZoneId.of("Europe/Paris"));
        event.updateStatus();

        assertEquals(EventStatus.COMPLETED, event.getStatus());
    }

    @Test
    void testOngoingEvent() {
        LocalDateTime oneHourAgo = LocalDateTime.now().minusHours(1);
        Event event = new Event("Current Event", oneHourAgo, ZoneId.systemDefault());
        event.updateStatus();

        assertEquals(EventStatus.ONGOING, event.getStatus());
    }


    @Test
    void testFutureEventStatus() {
        LocalDateTime future = LocalDateTime.now().plusHours(10);
        Event event = new Event("Future Event", future, ZoneId.of("Asia/Tokyo"));

        event.updateStatus();
        assertEquals(EventStatus.SCHEDULED, event.getStatus());
    }
}
