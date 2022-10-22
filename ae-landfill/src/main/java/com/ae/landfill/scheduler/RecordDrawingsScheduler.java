package com.ae.landfill.scheduler;

import com.ae.landfill.process.RecordDrawingsProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RecordDrawingsScheduler {

    @Autowired
    RecordDrawingsProcess recordDrawingsProcess;

    public static final Logger logger = LoggerFactory.getLogger(RecordDrawingsScheduler.class);


    //https://crontab.cronhub.io/
    @Scheduled(cron = "0 30 6 * * TUE,THU,SUN")
    public void ScheduleTask() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        String strDate = dateFormat.format(new Date());
        logger.info("Cron job Scheduler: Job running at - " + strDate);

        if(!recordDrawingsProcess.invoke()){
            logger.error("RecordDrawingsScheduler was unable to record drawings");
        }
    }
}
