package com.sys.dao;

import com.sys.entity.CustomerPo;
import com.sys.entity.OrderPo;
import com.sys.entity.ReturnCarPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/25
 **/
@Repository
public interface CustomerDao {
    /**
     * 用户上传材料
     * @param customerPo
     * @return
     */
    int insertCustomer(CustomerPo customerPo);

    /**
     * 查询订单进度
     * @param userName
     * @return
     */
    List<OrderPo> findOrderByuserName(String userName);

    /**
     * 根据账户名查询真实姓名
     * @param userName
     * @return
     */
    String findNameByUserName(String userName);

    /**
     * 查询所有待归还订单
     * @return
     */
    List<OrderPo> findNoReturn();
    /**
     * 车辆归还根据订单id添加结束时间,修改归还状态,修改订单状态
     * @param returnCarPo
     * @return
     */
    int finishRuturnCar(ReturnCarPo returnCarPo);
    /**
     * 根据车辆编号修改车辆状态
     * @param returnCarPo
     * @return
     */
    int updateCarstate(ReturnCarPo returnCarPo);

    /**
     * 根据id得到车辆使用时长(单位秒)
     * @param id
     * @return
     */
    Long findOderTimeByid(Integer id);
    /**
     *
     * @param id
     * @param price
     * @return
     */
    int updateOrderPrice(@Param("id") Integer id, @Param("price") Double price);

    /**
     * 根据商车牌号查询价格
     * @param carNo
     * @return
     */
    Double findPriceByNO(String carNo);
}
