package com.ae.landfill.process;

import com.ae.landfill.adapter.DataGovAPIAdapter;
import com.ae.landfill.adapter.DrawingsSQLAdapter;
import com.ae.landfill.model.Drawing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RecordDrawingsProcess {

    @Autowired
    DataGovAPIAdapter dataGovAPIAdapter;

    @Autowired
    DrawingsSQLAdapter drawingsSQLAdapter;

    public static final Logger logger = LoggerFactory.getLogger(RecordDrawingsProcess.class);

    @EventListener(ApplicationReadyEvent.class)
    public void postConstruct(){
        logger.info("Started initializing record process");
        if(invoke())
            logger.info("Successfully Recorded Drawings");
        else
            logger.warn("Unsuccessfully Recorded Drawings");
    }

    public Boolean invoke() {
        Boolean success = true;

        List<Drawing> distinctDrawings = getDistinctDrawings();
        if(distinctDrawings.isEmpty())
            logger.error("No new drawings were retrieved");

        if(!populateDrawingsTable(distinctDrawings)) {
            logger.error("Unable to populate drawings into drawings table");
            success = false;
        }

        return success;
    }

    protected List<Drawing> getDistinctDrawings() {
        List<Drawing> currentDrawings = dataGovAPIAdapter.getDrawings();
        List<Drawing> previousDrawings = drawingsSQLAdapter.getDrawings();

        if(currentDrawings.size() > 1) {
            currentDrawings = currentDrawings.stream()
                    .filter(currentDrawing -> !previousDrawings.contains(currentDrawing))
                    .collect(Collectors.toList());
        } else {
            logger.error("Was unable to pull current drawings, received {} results", currentDrawings.size());
        }

        return currentDrawings;
    }

    private Boolean populateDrawingsTable(List<Drawing> distinctDrawings) {
       Boolean inserted = false;
        for(Drawing drawing : distinctDrawings) {
            try {
                int rows= drawingsSQLAdapter.insertDrawing(drawing);
                if(rows > 0) {
                    inserted= true;
                }
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return inserted;
    }
}
