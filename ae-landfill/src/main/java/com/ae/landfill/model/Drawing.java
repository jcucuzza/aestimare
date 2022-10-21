package com.ae.landfill.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Getter @Setter
@ToString
public class Drawing {
    @JsonProperty(value = "draw_date")
    private String drawDate;
    @JsonProperty(value = "winning_numbers")
    private String winningNumbers;
    @JsonProperty(value = "multiplier")
    private String multiplier;

    public void setDrawDate(String drawDate){
        if(drawDate.length() > 10)
            this.drawDate = drawDate.substring(0,10);
        else
            this.drawDate = drawDate;
    }

    public Long getEpochTime() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date = df.parse(this.drawDate);
        return date.getTime();
    }
}
