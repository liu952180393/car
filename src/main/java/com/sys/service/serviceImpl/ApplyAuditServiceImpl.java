package com.sys.service.serviceImpl;

import com.sys.Utlis.DateUtil;
import com.sys.dao.ApplyAuditDao;
import com.sys.entity.AuditPo;
import com.sys.entity.PassOrderPo;
import com.sys.service.ApplyAuditService;
import com.sys.vo.AuditVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
public class ApplyAuditServiceImpl implements ApplyAuditService {
    @Autowired
    private ApplyAuditDao applyAuditDao;
    @Override
    public List<AuditVo> findAllaudit() {
        List<AuditPo> auditpoALlPo = applyAuditDao.findAuditpoALl();
        ArrayList<AuditVo> list = new ArrayList<>();
        for (AuditPo auditPo : auditpoALlPo) {
            AuditVo auditVo = new AuditVo();
            String ApplyTime = DateUtil.DateFormat(auditPo.getApplyTime());
            auditVo.setNumber( auditpoALlPo.indexOf(auditPo)+1);
            auditVo.setId(auditPo.getId()).setCarName(auditPo.getCarName()).setCarNo(auditPo.getCarNo())
                    .setOrderUser(auditPo.getOrderUser()).setCustomerName(auditPo.getCustomerName())
                    .setCustomerId(auditPo.getCustomerId()).setCustomerTel(auditPo.getCustomerTel())
                    .setCuetomerLicenseNo(auditPo.getCuetomerLicenseNo()).setApplyTime(ApplyTime);
            list.add(auditVo);
        }
        return list;
    }

    /**
     * 通过审核
     * @param passOrderPo
     * @return
     */
    @Override
    public int updateCarOrder(PassOrderPo passOrderPo) {
        applyAuditDao.updateCarStae(passOrderPo.getCarNo());
        return applyAuditDao.updateCarOrder(passOrderPo.getId());

    }
}
