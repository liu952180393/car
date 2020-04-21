package com.sys.controller;

import com.sys.entity.PassOrderPo;
import com.sys.service.ApplyAuditService;
import com.sys.vo.AuditVo;
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
public class ApplyAuditController {
    @Autowired
    private ApplyAuditService applyAuditService;
    @RequestMapping("/findauditAll")
    public List<AuditVo> findauditAll(){
        return applyAuditService.findAllaudit();
    }

    @RequestMapping("/updateCarOrder")
    public int updateCarOrder(PassOrderPo passOrderPo){
        return applyAuditService.updateCarOrder(passOrderPo);
    }
}
