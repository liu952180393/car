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
public class ApplyCarVo {
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
        private String carBuyTime;
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
         * 状态码
         */
        private Integer state;
        /**
         * 车名
         */
        private String carName;
        /**
         * 单价
         */
        private String carPrice;
}

