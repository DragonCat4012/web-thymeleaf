package com.mkyong.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WelcomeController {
    private Date dat = new Date();

    @GetMapping("/welcome")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model,
            @ModelAttribute ReservationForm form) {

        model.addAttribute("form", form);
        model.addAttribute("date", dat);
        return "welcome";
    }

    @PostMapping("/welcome/a")
    public String datePickerOnChange(@ModelAttribute("form") ReservationForm form, Model model,
            @RequestParam String date) {
        System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        System.out.println(date);
        System.out.println(form.getDate());
        //set date on form to new date
        //update data

        /*  [org.springframework.validation.BindException: org.springframework.validation.BeanPropertyBindingResult: 1 errors
        Field error in object 'form' on field 'date': rejected value [2023-11-29T11:20:17.719199]; codes [typeMismatch.form.date,typeMismatch.date,typeMismatch.java.time.LocalDateTime,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [form.date,date]; arguments []; default message [date]]; default message [Failed to convert value of type 'java.lang.String[]' to required type 'java.time.LocalDateTime'; nested exception is org.springframework.core.convert.ConversionFailedException: Failed to convert from type [java.lang.String] to type [@org.springframework.format.annotation.DateTimeFormat java.time.LocalDateTime] for value '2023-11-29T11:20:17.719199'; nested exception is java.lang.IllegalArgumentException: Parse attempt failed for value [2023-11-29T11:20:17.719199]]]
          */
        return "welcome";
    }
}