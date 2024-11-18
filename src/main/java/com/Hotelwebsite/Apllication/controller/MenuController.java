package com.Hotelwebsite.Apllication.controller;

import org.springframework.web.bind.annotation.GetMapping;
@org.springframework.stereotype.Controller

public class MenuController {

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }
}
