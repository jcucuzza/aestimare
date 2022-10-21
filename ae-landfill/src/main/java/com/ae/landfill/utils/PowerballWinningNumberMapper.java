package com.ae.landfill.utils;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PowerballWinningNumberMapper implements RowMapper {

    public PowerballWinningNumber mapRow(ResultSet rs, int rowNum) throws SQLException {
        PowerballWinningNumber pb = new PowerballWinningNumber();
        pb.setDrawDate(rs.getString("draw_date"));
        pb.setDrawDateEpoch(rs.getString("draw_date_epoch"));
        pb.setFirstNumber(rs.getInt("winning_number_one"));
        pb.setSecondNumber(rs.getInt("winning_number_two"));
        pb.setThirdNumber(rs.getInt("winning_number_three"));
        pb.setFourthNumber(rs.getInt("winning_number_four"));
        pb.setFifthNumber(rs.getInt("winning_number_five"));
        pb.setPowerBallNumber(rs.getInt("power_ball"));
        return pb;
    }

}
