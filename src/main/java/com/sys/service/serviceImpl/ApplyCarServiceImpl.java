package com.sys.service.serviceImpl;

import com.sys.dao.ApplyCarDao;
import com.sys.entity.OrderPo;
import com.sys.service.ApplyCarService;
import com.sys.vo.ApplyCarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/25
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
@Service
public class ApplyCarServiceImpl implements ApplyCarService {
    @Autowired
    private ApplyCarDao applyCarDao;
    @Override
    public List<ApplyCarVo> findAllfree() {
        return null;
    }

    @Override
    public int applyOrder(String carNO,Integer id) {
        int rows1 = applyCarDao.applyOrder(carNO);
        int rows2 = applyCarDao.updatecarState(id);
        return rows1+rows2;
    }

}
