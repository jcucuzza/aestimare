package com.ae.landfill.adapter;

import com.ae.landfill.model.PowerballWinningNumber;
import com.ae.landfill.utils.PowerballWinningNumberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class DrawingsAdapter {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional(readOnly=true)
    public List<PowerballWinningNumber> findAllWinningNumbers() {
        return jdbcTemplate.query("select * from winning_numbers", new PowerballWinningNumberMapper());
    }

    @Transactional
    public boolean insertToTallyAllSumTable(Map<String, Map<Integer, Integer>> tallyBySum){
        boolean processed = true;

        tallyBySum.get("numbers").forEach((ball, tally) ->{
            jdbcTemplate.update("insert into tally_all_sum(number_" + ball + ") VALUES (" + tally + ")");
        });
        tallyBySum.get("powerballs").forEach((ball,tally) ->{
            jdbcTemplate.update("insert into tally_all_sum(powerball_" + ball  + ") VALUES (" + tally + ")");
        });
        return processed;
    }

}
