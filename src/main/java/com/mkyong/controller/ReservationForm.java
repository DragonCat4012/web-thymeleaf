package com.mkyong.controller;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservationForm {
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime date;

    public ReservationForm(LocalDateTime date) {
        this.date = LocalDateTime.now();
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
