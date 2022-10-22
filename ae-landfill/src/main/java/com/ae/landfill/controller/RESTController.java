package com.ae.landfill.controller;

import com.ae.landfill.adapter.DrawingsSQLAdapter;
import com.ae.landfill.model.Drawing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/")
public class RESTController {

    @Autowired
    DrawingsSQLAdapter drawingsSQLAdapter;

    @GetMapping(path = "/health", produces = "application/json")
    public boolean health() {
        return true;
    }

    @GetMapping(path = "/count", produces = "application/json")
    public int  count() {
        return drawingsSQLAdapter.getCount();
    }

    @GetMapping(path = "/between-dates", produces = "application/json")
    public String  betweenDates() {
        return "";
    }

    @GetMapping(path = "/latest-drawing", produces = "application/json")
    public Drawing latestDrawing() {
        return drawingsSQLAdapter.getLatestDrawing();
    }

}
