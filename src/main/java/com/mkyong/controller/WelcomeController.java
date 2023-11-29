package com.mkyong.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
    private Date dat = new Date();

    @GetMapping("/welcome")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("date", dat);
        return "welcome";
    }

    @PostMapping("/welcome/a")
    public String datePickerOnChange(Model model,
            @RequestParam String date) {
        System.out.println(date); //Wed Nov 29 14:01:31 CET 2023

        // TODO: date = newDate;
        return "welcome";
    }
}