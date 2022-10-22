package com.ae.landfill.adapter;

import com.ae.landfill.model.Drawing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@Service
public class DrawingsSQLAdapter {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static final Logger logger = LoggerFactory.getLogger(DrawingsSQLAdapter.class);

    @Transactional(readOnly = true)
    public Integer getCount() {
        final String SQL = "select count(*) from drawings";
        return jdbcTemplate.queryForObject(SQL, Integer.class);
    }

    @Transactional(readOnly=true)
    public List<Drawing> getDrawings() {
        final String SQL = "select * from drawings";
        return jdbcTemplate.query(SQL, new DrawingsMapper());
    }


    @Transactional(readOnly = true)
    public Drawing getLatestDrawing(){
        final String SQL = "select * from drawings order by draw_date desc limit 1";
        return jdbcTemplate.query(SQL, new DrawingsMapper()).get(0);
    }

    @Transactional
    public Integer insertDrawing(Drawing d) throws DataAccessException, ParseException {
        final String SQL = "insert into drawings(draw_date, draw_date_epoch, winning_numbers, multiplier) values (?:: TIMESTAMP, ?, ?, CAST(? AS INT))";
        return jdbcTemplate.update(SQL, d.getDrawDate(), d.getEpochTime(), d.getWinningNumbers(), d.getMultiplier());
    }





    public static class DrawingsMapper  implements RowMapper<Drawing> {
        @Override
        public Drawing mapRow(ResultSet rs, int rowNum) throws SQLException {
            Drawing drawing = new Drawing();

            drawing.setDrawDate(String.valueOf(rs.getDate("draw_date")));
            drawing.setWinningNumbers(rs.getString("winning_numbers"));
            drawing.setMultiplier(rs.getString("multiplier"));

            return drawing;
        }
    }
}
