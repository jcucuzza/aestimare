package com.ae.landfill.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PowerballWinningNumber {
    private String drawDate;
    private String drawDateEpoch;
    private Integer firstNumber;
    private Integer secondNumber;
    private Integer thirdNumber;
    private Integer fourthNumber;
    private Integer fifthNumber;
    private Integer powerBallNumber;
}
