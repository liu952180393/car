package com.sys.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/25
 **/
@Data
@Accessors(chain = true)
public class OrderPo {
    /**
     * 全局统一标识符
     * */
    private Integer id;
    /**
     * 车牌号
     */
    private String carNo;
    /**
     *申请租车时间
     */
    private Date applyTime;
    /**
     * 订单开始时间
     */
    private Date orderStarTime;
    /**
     * 订单状态
     */
    private Integer orderState;
    /**
     * 订单价格
     */
    private Double orderPrice;
    /**
     * 订单价格
     */
    private Integer returnState;
    /**
     * 订单结束时间
     */
    private Date orderEndTime;
}
