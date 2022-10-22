package com.ae.landfill.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawingsTest {

    private Drawing drawing;
    @BeforeEach
    void setUp() {
        drawing = new Drawing();
    }

    @ParameterizedTest
    @CsvSource({
            "2022-01-01T00:00:00, 2022-01-01",
            "2022-01-02, 2022-01-02"
    })
    void setDrawDateTest(String actual, String expected) {
        drawing.setDrawDate(actual);
        actual = drawing.getDrawDate();
        assertEquals(expected, actual, actual + " date length and format should appear as expected ->  " + expected);
    }

    @ParameterizedTest
    @CsvSource({
            "2022-01-01, 1640995200000"
    })
    void getEpochTime(String date, long expected ) throws ParseException {
        drawing.setDrawDate(date);
        long actual = drawing.getEpochTime();
        assertEquals(expected, actual, actual + " date conversion into milliseconds should appear as expected ->  " + expected);
    }
}
