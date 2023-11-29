package com.mkyong.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    private String message;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "welcome"; //view
    }

    // /hello?name=kotlin
    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name, Model model,
            @ModelAttribute ReservationForm form) {

        model.addAttribute("form", form);
        return "welcome";
    }

    @PostMapping("/hello/a")
    public String datePickerOnChange(@ModelAttribute("form") ReservationForm form, Model model,
            @RequestParam String date) {
        System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        System.out.println(date);
        //set date on form to new date
        //update data

        /*  [org.springframework.validation.BindException: org.springframework.validation.BeanPropertyBindingResult: 1 errors
        Field error in object 'form' on field 'date': rejected value [2023-11-29T11:20:17.719199]; codes [typeMismatch.form.date,typeMismatch.date,typeMismatch.java.time.LocalDateTime,typeMismatch]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [form.date,date]; arguments []; default message [date]]; default message [Failed to convert value of type 'java.lang.String[]' to required type 'java.time.LocalDateTime'; nested exception is org.springframework.core.convert.ConversionFailedException: Failed to convert from type [java.lang.String] to type [@org.springframework.format.annotation.DateTimeFormat java.time.LocalDateTime] for value '2023-11-29T11:20:17.719199'; nested exception is java.lang.IllegalArgumentException: Parse attempt failed for value [2023-11-29T11:20:17.719199]]]
          */
        return "hello";
    }
}