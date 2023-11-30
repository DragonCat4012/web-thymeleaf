package com.mkyong.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Alley {
    private List<TimeSlot> slots;
    private int cost;
    private int maxpeople;

    public Alley(int cost, int maxpeople, int timeslots) {
        this.cost = cost;
        this.maxpeople = maxpeople;
        List<TimeSlot> arr = new ArrayList<>();

        for (int i = 0; i < timeslots; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.HOUR_OF_DAY, 1 * i);
            if (cal.get(Calendar.HOUR) > WelcomeController.closingHour) {
                continue;
            }
            arr.add(new TimeSlot(cal.getTime().getTime()));
        }
        this.slots = arr;
    }

    public List<TimeSlot> getSlots() {
        return slots;
    }

    public void setSlots(List<TimeSlot> slots) {
        this.slots = slots;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getMaxpeople() {
        return maxpeople;
    }

    public void setMaxpeople(int maxpeople) {
        this.maxpeople = maxpeople;
    }

    @Override
    public String toString() {
        return "Alley [slots=" + slots.size() + ", cost=" + cost + ", maxpeople=" + maxpeople + "]";
    }
}
