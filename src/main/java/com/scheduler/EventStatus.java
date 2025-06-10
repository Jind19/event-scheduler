package com.scheduler;

public enum EventStatus {
    SCHEDULED,
    ONGOING,
    COMPLETED,
    CANCELLED;

    public boolean isFinal() {
        return this == COMPLETED || this == CANCELLED;
    }

}
