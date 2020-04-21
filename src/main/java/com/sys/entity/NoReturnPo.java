package com.sys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 描述：查询所有待归还订单
 *
 * @author PuYinsheng
 * @date 2020/4/19
 **/
@Data
public class NoReturnPo {
    /**
     * 订单id
     */
    private  Integer id;
    /**
     * 车牌号
     */
    private String carNo;
    /**
     * 下单时间
     */
    @JsonFormat(pattern = "yyy/MM/dd HH:mm")
    private Date orderStarTime;
    /**
     * 下单人
     */
    private String name;
}
