package com.ae.landfill.controller;

import com.ae.landfill.adapter.DrawingsSQLAdapter;
import com.ae.landfill.model.Drawing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "/")
public class RESTController {

    @Autowired
    DrawingsSQLAdapter drawingsSQLAdapter;

    private static final String APPLICATION_JSON = "application/json";
    @GetMapping(path = "/health", produces = APPLICATION_JSON)
    public boolean health() {
        return true;
    }

    @GetMapping(path = "/count", produces = APPLICATION_JSON)
    public int  count() {
        return drawingsSQLAdapter.getCount();
    }

    @GetMapping(path = "/drawings", produces = APPLICATION_JSON)
    public List<Drawing> getDrawings() {
        return drawingsSQLAdapter.getDrawings();
    }

    @GetMapping(path = "/between-dates", produces = APPLICATION_JSON)
    public String  betweenDates() {
        return "";
    }

    @GetMapping(path = "/latest-drawing", produces = APPLICATION_JSON)
    public Drawing latestDrawing() {
        return drawingsSQLAdapter.getLatestDrawing();
    }

}
