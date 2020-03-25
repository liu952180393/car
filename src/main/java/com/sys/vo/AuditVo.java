package com.sys.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/25
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
@Data
@Accessors(chain = true)
public class AuditVo {
    /**
     * 序号
     */
    private Integer number;
    /**
     * 订单id
     */
    private  Integer id;
    /**
     * 车名
     */
    private String carName;
    /**
     * 车牌号
     */
    private  String carNo;
    /**
     * 账户
     */
    private String orderUser;
    /**
     * 申请人姓名
     */
    private String customerName;
    /**
     * 身份证号
     */
    private String customerId;
    /**
     * 电话号
     */
    private  String customerTel;
    /**
     * 驾驶证号
     */
    private String cuetomerLicenseNo;
    /**
     * 申请时间
     */
    private String applyTime;
}
