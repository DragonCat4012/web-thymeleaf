package com.mkyong.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
    private Date dat = new Date();
    private int openingHour = 10;
    private int closingHour = 20;

    @GetMapping("/welcome")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        List<Date> colums = initTimeslotsFromSelectedTime(dat.getTime());
        model.addAttribute("date", dat);
        model.addAttribute("dates", colums);
        model.addAttribute("alleys", alleys(colums.size()));
        return "welcome";
    }

    @PostMapping("/welcome/a")
    public String datePickerOnChange(Model model,
            @RequestParam String date) {
        System.out.println(date); //Wed Nov 29 14:01:31 CET 2023

        // TODO: date = newDate;
        return "welcome";
    }

    @PostMapping("/welcome/b")
    public String typeOnchange(Model model,
            @RequestParam String type) {
        System.out.println(type);

        return "welcome";
    }

    @PostMapping("/welcome/d")
    public String bokTimeslot(Model model,
            @RequestParam String slot) {
        System.out.println(slot);

        return "welcome";
    }

    private List<Integer> alleys(int count) {
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            arr.add(i);
        }
        return arr;
    }

    private List<Date> initTimeslotsFromSelectedTime(long date) {
        long selected = getCleanDate(1701435600);
        List<Date> arr = new ArrayList<>();
        int openingTime = 13;
        int closingTime = 13;

        int hour = 1000 * 60 * 60 * 60;

        for (int i = 0; i < 7; i++) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date(date));
            cal.add(Calendar.HOUR_OF_DAY, 1 * i);
            arr.add(cleanDate(cal.getTime()));
        }
        return arr;
    }

    public Date cleanDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (calendar.get(Calendar.MINUTE) > 15 && calendar.get(Calendar.MINUTE) < 45) {
            calendar.set(Calendar.MINUTE, 30);
        } else {
            calendar.set(Calendar.MINUTE, 0);
        }
        return calendar.getTime();
    }

    public long getCleanDate(long timestamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(timestamp * 1000);
        calendar.set(Calendar.HOUR_OF_DAY, openingHour);
        if (calendar.get(Calendar.MINUTE) > 15 && calendar.get(Calendar.MINUTE) < 45) {
            calendar.set(Calendar.MINUTE, 30);
        } else {
            calendar.set(Calendar.MINUTE, 0);
        }
        return calendar.getTime().getTime();
    }

    private List<Integer> initArrTimesTaken() {
        List<Integer> arr = new ArrayList<>();
        arr.add(1701340620); // Nov 30 2023 10:37
        arr.add(1701344220); // Nov 30 2023 11:37
        arr.add(1701257820); // Nov 29 2023 11:37
        arr.add(1701435600); // Dec 01 2023 13:00
        return arr;
    }
}