package com.ae.landfill.process;

import com.ae.landfill.model.PowerballWinningNumber;
import com.ae.landfill.adapter.DrawingsAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class PowerballTallyProcess {

    @Autowired
    DrawingsAdapter powerballWinningService;

    List<PowerballWinningNumber> powerballHistory;

    public static final Logger logger = LoggerFactory.getLogger(PowerballTallyProcess.class);

    @PostConstruct
    public void init(){
        
        //powerballHistory = powerballWinningService.findAllDrawings();
        
        //logger.info("powerball history size {}", powerballHistory.size());
    }

    public Map<String, Map<Integer, Integer>>  getTallyBySum() {
        
        Map<String, Map<Integer, Integer>> previousWinnings = new LinkedHashMap<>();
        int[] numbers = new int[70], powerballs = new int[46];

        powerballHistory.forEach(w -> {
            try {
                numbers[w.getFirstNumber()]++;
                numbers[w.getSecondNumber()]++;
                numbers[w.getThirdNumber()]++;
                numbers[w.getFourthNumber()]++;
                numbers[w.getFifthNumber()]++;
                powerballs[w.getPowerBallNumber()]++;
            } catch (NullPointerException e){
                e.printStackTrace();
            }
        });

        previousWinnings.put("numbers", convertToMap(numbers));
        previousWinnings.put("powerball", convertToMap(powerballs));

        return previousWinnings;
    }

    private Map<Integer, Integer>  convertToMap(int[] arr){
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for(int i = 1; i < arr.length; i++)
            map.put((i), arr[i]);

        return map;
    }

}
