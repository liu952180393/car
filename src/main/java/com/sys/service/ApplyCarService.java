package com.sys.service;

import com.sys.vo.ApplyCarVo;

import java.util.List;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/25
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
public interface ApplyCarService {
    List<ApplyCarVo> findAllfree();
    int applyOrder(Integer id);
}
