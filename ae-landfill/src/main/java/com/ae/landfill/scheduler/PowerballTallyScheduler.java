package com.ae.landfill.scheduler;

import com.ae.landfill.adapter.DrawingsSQLAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class PowerballTallyScheduler {

    @Autowired
    PowerballTallyProcess powerballTallyProcess;

    @Autowired
    DrawingsSQLAdapter powerballWinningService;

    public static final Logger logger = LoggerFactory.getLogger(PowerballTallyScheduler.class);

    //http://www.cronmaker.com/
    //@Scheduled(cron = "0 3 11 ? * MON,WED,SAT *")
    @Scheduled(cron = "0 0/2 * 1/1 * ? *")
    public void cronJobSchTallyBySum() {

//        if(powerballWinningService.insertToTallyAllSumTable(powerballTallyProcess.getTallyBySum()))
//            logger.info("tallySumAll updated");
//        else
//            logger.info("tallySumAll not updated!");
    }


}
