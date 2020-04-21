package com.sys.service;

import com.sys.dao.UserDao;
import com.sys.entity.NoReturnPo;
import com.sys.entity.OrderPo;
import com.sys.entity.ReturnCarPo;
import com.sys.entity.UserPo;
import com.sys.vo.CustomerVo;

import java.util.List;

/**
 * 描述：用户
 *
 * @author
 * @date 2020/3/25
 **/
public interface CustomerService {
    /**
     * 用户上传材料
     * @param customerVo
     * @return
     */
    int insertCustomer(CustomerVo customerVo);
    /**
     * 查询订单进度
     * @param userName
     * @return
     */
    List<OrderPo> findOrderByuserName(String userName);

    /**
     * 查询所有待归还订单
     * @return
     */
    List<NoReturnPo> findNoReturnPo();

    /**
     * 归还车辆
     * @param returnCarPo
     * @return
     */
    String finishOrder(ReturnCarPo returnCarPo);
    /**
     * 查询所有普通用户
     * @return
     */
    List<UserPo> findAllUser();
    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int deleteUserByid(Integer id);
}
