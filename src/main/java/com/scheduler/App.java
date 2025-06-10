package com.scheduler;


import java.time.LocalDateTime;
import java.time.ZoneId;

public class App {

    public static void main( String[] args ) {
        // Creating events in different timezones
        Event event1 = new Event(
                "Java Meetup NYC",
                LocalDateTime.now().minusHours(3),
                ZoneId.of("America/New_York")
        );

        Event event2 = new Event(
                "Online Workshop Tokyo",
                LocalDateTime.now().plusHours(2),
                ZoneId.of("Asia/Tokyo")
        );

        Event event3 = new Event(
                "Lunch & Code Paris",
                LocalDateTime.now().minusHours(1),
                ZoneId.of("Europe/Paris")
        );

        //Update event status
        event1.updateStatus();
        event2.updateStatus();
        event3.updateStatus();

        //Print event status
        event1.printDetails();
        event2.printDetails();
        event3.printDetails();

    }
}
