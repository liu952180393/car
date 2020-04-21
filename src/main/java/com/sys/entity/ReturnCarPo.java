package com.sys.entity;

import lombok.Data;

/**
 * 描述：归还车辆入参
 *
 * @author PuYinsheng
 * @date 2020/4/19
 **/
@Data
public class ReturnCarPo {
    /**
     * 订单id
     */
    private Integer id;
    /**
     * 车牌号
     *
     */
    private String carNo;
    /**
     * 车辆状态
     */
    private Integer carState;
}
