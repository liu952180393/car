package com.sys.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/25
 **/
@Data
@Accessors(chain = true)
public class CustomerVo {
    /**
     * 全局统一标识符
     */
    private Integer id;
    /**
     * 用户账号
     */
    private String customerNo;
    /**
     * 姓名
     */
    private String customerName;
    /**
     * 性别
     */
    private String customerSex;
    /**
     * 年龄
     */
    private Integer customerAge;
    /**
     * 身份证号
     */
    private String customerId;
    /**
     * 电话
     */
    private String customerTel;
    /**
     * 工作单位
     */
    private String customerWorkplace;
    /**
     * E-Mail
     */
    private String customerEmail;
    /**
     * 客户状态
     */
    private Integer customerStatus;
    /**
     * 地址
     */
    private String customerAddress;
    /**
     * 驾照号码
     */
    private String customerLicenseNo;
    /**
     * 驾照类型
     */
    private String customerLicenseType;
    /**
     * 驾龄
     */
    private Integer customerLicenseAges;
    /**
     * 发证日期
     */
    private String customerLicenseStartDate;
    /**
     * 到期日期
     */
    private String customerLicenseInvalidDate;
    /**
     * 状态
     */
    private Integer customerLicenseStatus;
    /**
     * 创建人
     */
    private String recordCreator;
    /**
     * 创建时间
     */
    private String recordCreateTime;
}
