package com.sys.service.serviceImpl;

import com.sys.Utlis.DateUtil;
import com.sys.dao.CustomerDao;
import com.sys.entity.CustomerPo;
import com.sys.service.CustomerService;
import com.sys.vo.CustomerVo;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/25
 **/
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;
    @SneakyThrows
    @Override
    public int insertCustomer(CustomerVo customerVo) {
        CustomerPo customerPo = new CustomerPo();
        Date CustomerLicenseInvalidDate = DateUtil.stringTOdate(customerVo.getCuetomerLicenseInvalidDate());
        Date CustomerLicenseStartDate = DateUtil.stringTOdate(customerVo.getCuetomerLicenseStartDate());
        customerPo.setCustomerNo(customerVo.getCustomerNo()).setCustomerName(customerVo.getCustomerName())
                .setCustomerSex(customerVo.getCustomerSex()).setCustomerAge(customerVo.getCustomerAge())
                .setCustomerId(customerVo.getCustomerId()).setCustomerTel(customerVo.getCustomerTel())
                .setCustomerWorkplace(customerVo.getCustomerWorkplace()).setCustomerEmail(customerVo.getCustomerEmail())
                .setCustomerAddress(customerVo.getCustomerAddress()).setCuetomerLicenseNo(customerVo.getCuetomerLicenseNo())
                .setCuetomerLicenseType(customerVo.getCuetomerLicenseType()).setCuetomerLicenseAges(customerVo.getCuetomerLicenseAges())
                .setCuetomerLicenseStartDate(CustomerLicenseStartDate).setCuetomerLicenseInvalidDate(CustomerLicenseInvalidDate);
        int rows = customerDao.insertCustomer(customerPo);
        return rows;
    }
}
