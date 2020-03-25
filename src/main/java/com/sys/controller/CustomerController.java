package com.sys.controller;
import com.sys.service.CustomerService;
import com.sys.service.UserService;
import com.sys.vo.CustomerVo;
import com.sys.vo.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/25
 **/
@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private UserService userService;

    @RequestMapping("/insertCustomer")
    public Status insertCustomer(CustomerVo customerVo) {
        int rows = customerService.insertCustomer(customerVo);
        Status status = new Status();
        status.setStatus(0);
        if(rows==1){
            status.setStatus(rows);
        }
        return  status;
    }
    /**
     * 用户账号查重
     */
    boolean userAccountCompar(String account) {
        return false;
    }

}
