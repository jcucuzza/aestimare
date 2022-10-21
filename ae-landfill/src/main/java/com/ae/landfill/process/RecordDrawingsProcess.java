package com.ae.landfill.process;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class RecordDrawingsProcess {

    public static final Logger logger = LoggerFactory.getLogger(RecordDrawingsProcess.class);

    @EventListener(ApplicationReadyEvent.class)
    public void postConstruct(){
        logger.info("Started initializing record process");
        
    }
}
