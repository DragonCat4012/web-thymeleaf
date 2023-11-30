package com.mkyong.controller;

import java.util.Date;
import java.util.Random;

public class TimeSlot {
    private long time;
    private boolean booked;

    public TimeSlot(long time) {
        this.time = time;
        Random random = new Random();
        this.booked = random.nextBoolean();
    }

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
