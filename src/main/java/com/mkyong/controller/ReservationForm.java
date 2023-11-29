package com.mkyong.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservationForm {
    @DateTimeFormat(pattern = "dd/MM/yyyy h:mm")
    private LocalDateTime date;

    public ReservationForm(LocalDateTime date) {
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        System.out.println(date);
        System.out.println(">>>");
        this.date = date;
    }

    public void setDate(String date) {
        this.date = LocalDateTime.now();
    }
}
