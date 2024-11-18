package com.Hotelwebsite.Apllication.controller;

import org.springframework.web.bind.annotation.GetMapping;
@org.springframework.stereotype.Controller

public class congratulation {

    @GetMapping("/congratulation")
    public String congratulation() {
        return "congratulation";
    }
}
