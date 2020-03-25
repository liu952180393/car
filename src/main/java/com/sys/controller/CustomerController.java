package com.sys.controller;

import com.sys.Utlis.DateUtil;
import com.sys.entity.CustomerPo;
import com.sys.service.CustomerService;
import com.sys.service.UserService;
import com.sys.vo.CustomerVo;
import com.sys.vo.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.util.Date;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/25
 **/
@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;

    @RequestMapping("/insertCustomer")
    public Status insertCustomer(CustomerVo customerVo) throws ParseException {
        Status status = new Status();
        CustomerPo customerPo = new CustomerPo();
        Date customerLicenseInvalidDate = DateUtil.stringTOdate(customerVo.getCustomerLicenseInvalidDate());
        Date CustomerLicenseStartDate = DateUtil.stringTOdate(customerVo.getCustomerLicenseStartDate());
        customerPo.setCustomerNo(customerVo.getCustomerNo()).setCustomerName(customerVo.getCustomerName())
                .setCustomerSex(customerVo.getCustomerSex()).setCustomerAge(customerVo.getCustomerAge())
                .setCustomerId(customerVo.getCustomerId()).setCustomerTel(customerVo.getCustomerTel())
                .setCustomerWorkplace(customerVo.getCustomerWorkplace()).setCustomerEmail(customerVo.getCustomerEmail())
                .setCustomerStatus(customerVo.getCustomerStatus()).setCustomerAddress(customerVo.getCustomerAddress())
                .setCustomerLicenseNo(customerVo.getCustomerLicenseNo()).setCustomerLicenseType(customerVo.getCustomerLicenseType())
                .setCustomerLicenseAges(customerVo.getCustomerLicenseAges()).setCustomerLicenseStartDate(CustomerLicenseStartDate)
                .setCustomerLicenseInvalidDate(customerLicenseInvalidDate).setCustomerLicenseStatus(customerVo.getCustomerLicenseStatus());
        int rows = customerService.insertCustomer(customerPo);
        status.setStatus(rows);
        return  status;
    }
    /**
     * 用户账号查重
     */
    boolean userAccountCompar(String account) {
        return false;
    }

}
