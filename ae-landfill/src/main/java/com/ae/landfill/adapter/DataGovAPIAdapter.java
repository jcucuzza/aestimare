package com.ae.landfill.adapter;

import com.ae.landfill.model.Drawing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class DataGovAPIAdapter {
    
    private static final String URI_DATA_ENDPOINT= "https://data.ny.gov/resource/d6yy-54nr.json";
    private static final String URI_COUNT_ENDPOINT = "https://data.ny.gov/api/id/d6yy-54nr?$query=select%20count(*)%20as%20column_count";

    public static final Logger logger = LoggerFactory.getLogger(DataGovAPIAdapter.class);

    public List<Drawing> getDrawings() {
        Drawing[] drawingResponse = new RestTemplate().getForObject(URI_DATA_ENDPOINT, Drawing[].class);
        return Arrays.asList(drawingResponse);
    }

    public Integer getCount(){
        Integer countResponse = new RestTemplate().getForObject(URI_DATA_ENDPOINT, Integer.class);
        return countResponse;
    }

}
