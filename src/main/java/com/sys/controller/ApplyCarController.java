package com.sys.controller;

import com.sys.entity.CarPo;
import com.sys.entity.OrderPo;
import com.sys.service.ApplyCarService;
import com.sys.service.CarService;
import com.sys.vo.ApplyCarVo;
import com.sys.vo.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/25
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
@RestController
public class ApplyCarController {
    @Autowired
    private ApplyCarService applyCarService;

    @RequestMapping("/finAllFree")
    public List<ApplyCarVo> finAllFree(){

        return applyCarService.findAllfree();
    }
    @RequestMapping("/applyOrder")
    public Status applyOrder(String carNo,Integer id,String userName){
        Status status = new Status();
        int result = applyCarService.applyOrder(carNo, id, userName);
        status.setStatus(result);
        return status;
    }
}
