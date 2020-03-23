package com.sys.entity;

import lombok.Data;

import java.util.Date;
/**
 * @author liu
 */
@Data
public class Car {
    /**
     * 全局统一标识符
     * */
    private Integer id;
    /**
     * 序号
     */
    private Integer number;
    /**
     * 车牌号
     */
    private String carNo;
    /**
     *车辆颜色
     */
    private String carColor;
    /**
     * 购买时间
     */
    private Date carBuyTime;
    /**
     * 发动机编号
     */
    private String carEngineNo;
    /**
     * 车架编号
     */
    private String carFrameNo;
    /**
     * 燃油编号
     */
    private String carFuelNo;
    /**
     * 车辆状态
     */
    private String carStatus;
    /**
     * 记录创建人
     */
    private String recordCreator;
    /**
     * 记录创建使劲按
     */
    private Date recordCreateTime;
    /**
     * 状态码
     */
    private Integer state;
}
