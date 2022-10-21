package com.ae.landfill.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/")
public class RESTController {

    @GetMapping(path = "/health", produces = "application/json")
    public boolean  health() {
        return true;
    }

    @GetMapping(path = "/count", produces = "application/json")
    public int  count() {
        return 0;
    }

    @GetMapping(path = "/betweendates", produces = "application/json")
    public String  betweenDates() {
        return "";
    }

    @GetMapping(path = "/latestdrawing", produces = "application/json")
    public String latestDrawing() {
        return "";
    }

}
