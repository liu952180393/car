package com.sys.entity;

import lombok.Data;

/**
 * 描述：提交订单
 *
 * @author PuYinsheng
 * @date 2020/4/19
 **/
@Data
public class PassOrderPo {
    /**
     * 订单id
     */
    private Integer id;
    /**
     * 车牌号
     */
    private String carNo;
}
