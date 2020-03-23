package com.sys.entity;

import lombok.Data;

import java.util.Date;
/**
 * @author liu
 */
@Data
public class Car {
    private Integer id;
    private String carNo;
    private String carColor;
    private Date carBuyTime;
    private String carEngineNo;
    private String carFrameNo;
    private String carFuelNo;
    private String carStatus;
    private String recordCreator;
    private Date recordCreateTime;
    private Integer state;
}
