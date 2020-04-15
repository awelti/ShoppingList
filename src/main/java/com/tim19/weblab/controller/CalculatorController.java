package com.tim19.weblab.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {

    private int number = 0;

    @GetMapping
    public int get() {
        return this.number;
    }

    @PostMapping
    public int set(@RequestParam(name = "value") int value) {
        number = value;
        return number;
    }

    @PostMapping(path = "/add")
    public int add(@RequestParam(name = "value") int value) {
        number += value;
        return number;
    }

    @PostMapping(path = "/subtract")
    public int subtract(@RequestParam(name = "value") int value) {
        number -= value;
        return number;
    }

}
