package com.sys.controller;
import com.sys.dao.UserDao;
import com.sys.entity.*;
import com.sys.service.CustomerService;
import com.sys.service.UserService;
import com.sys.vo.CustomerVo;
import com.sys.vo.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    /**
     * 用户上传材料
     * @param customerVo
     * @return
     */
    @RequestMapping("/insertCustomer")
    public Status insertCustomer(CustomerVo customerVo) {
        int rows = customerService.insertCustomer(customerVo);
        Status status = new Status();
        status.setStatus(rows);
        return  status;
    }

    /**
     *用户查询订单进度
     * @param userName
     * @return
     */
    @RequestMapping("findOrderByuserName")
    public List<OrderPo>findOrderByuserName(String userName){
        List<OrderPo> orderByuserName = customerService.findOrderByuserName(userName);
        return orderByuserName;

    }

    /**
     * 查询代还车订单
     * @return
     */
    @RequestMapping("findNoReturnPo")
    public List<NoReturnPo> findNoReturnPo(){
        return customerService.findNoReturnPo();
    }

    /**
     * 归还车辆调用
     * @param returnCarPo
     * @return
     */
    @RequestMapping("finishOrder")
    public TotalPricePo finishOrder(ReturnCarPo returnCarPo){
        TotalPricePo totalPrice = new TotalPricePo();
        totalPrice.setPrice(customerService.finishOrder(returnCarPo));
        return totalPrice;
    }
}
