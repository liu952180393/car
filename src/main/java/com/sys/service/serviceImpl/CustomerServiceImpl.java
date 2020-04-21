package com.sys.service.serviceImpl;

import com.sys.Utlis.DateUtil;
import com.sys.Utlis.ParameterCalibration;
import com.sys.dao.ApplyCarDao;
import com.sys.dao.CustomerDao;
import com.sys.dao.UserDao;
import com.sys.entity.*;
import com.sys.service.CustomerService;
import com.sys.vo.CustomerVo;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.unit.DataUnit;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private UserDao userDao;
    @Autowired
    private   ApplyCarDao applyCarDao;
    /**
     * 上传材料
     * @param customerVo
     * @return
     */
    @SneakyThrows
    @Override
    public int insertCustomer(CustomerVo customerVo) {
        //参数非空校验
        if(customerVo.getCustomerName()==null || customerVo.getCustomerAge()==null || customerVo.getCustomerId()==null || customerVo.getCustomerTel()==null || customerVo.getCustomerWorkplace()==null || customerVo.getCustomerEmail()==null || customerVo.getCustomerAddress()==null || customerVo.getCuetomerLicenseNo()==null || customerVo.getCuetomerLicenseAges()==null || customerVo.getCuetomerLicenseInvalidDate()==null || customerVo.getCuetomerLicenseStartDate()==null){
            return -1;
        }
        //参数校验
        boolean reult0 = ParameterCalibration.checkNoOrCarOn(customerVo.getCustomerId());
        boolean reult1 = ParameterCalibration.checTel(customerVo.getCustomerTel());
        boolean reult2 = ParameterCalibration.checkEmail(customerVo.getCustomerEmail());
        boolean reult3 = ParameterCalibration.checkNoOrCarOn(customerVo.getCuetomerLicenseNo());
        boolean reult4 = ParameterCalibration.checkDriverAge(customerVo.getCuetomerLicenseAges());
        boolean reult5 = ParameterCalibration.checkDateString(customerVo.getCuetomerLicenseStartDate());
        boolean reult6 = ParameterCalibration.checkDateString(customerVo.getCuetomerLicenseInvalidDate());
        if(reult0 && reult1 && reult2 && reult3 && reult4 && reult5 && reult6){
            if(!(ParameterCalibration.checkCarCard(customerVo.getCuetomerLicenseStartDate(), customerVo.getCuetomerLicenseInvalidDate()))){
                    return -1;
            }
        }else {
            return -1;
        }
        //驾照查重（或以上传材料）
        String material = applyCarDao.findMaterial(customerVo.getCustomerNo());
        if(material!=null){
            return -2;
        }
        CustomerPo customerPo = new CustomerPo();
        Date CustomerLicenseInvalidDate = DateUtil.stringTOdate(customerVo.getCuetomerLicenseInvalidDate());
        Date CustomerLicenseStartDate =DateUtil.stringTOdate(customerVo.getCuetomerLicenseStartDate());
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

    /**
     * 用户查询订单进度
     * @param userName
     * @return
     */
    @Override
    public List<OrderPo> findOrderByuserName(String userName) {
        return customerDao.findOrderByuserName(userName);
    }

    /**
     * 查询所有待归还订单
     * @return
     */
    @Override
    public List<NoReturnPo> findNoReturnPo() {
        ArrayList<NoReturnPo> noReturnPos = new ArrayList<>();
        List<OrderPo> noReturn = customerDao.findNoReturn();
        for (OrderPo orderPo : noReturn) {
            NoReturnPo noReturnPo = new NoReturnPo();
            BeanUtils.copyProperties(orderPo,noReturnPo);
            noReturnPo.setName(customerDao.findNameByUserName(orderPo.getOrderUser()));
            noReturnPos.add(noReturnPo);
        }
        return noReturnPos;
    }

    /**
     * 归还车辆
     * @param returnCarPo
     * @return
     */
    @Override
    public String finishOrder(ReturnCarPo returnCarPo) {
        //1修改订单状态
        customerDao.finishRuturnCar(returnCarPo);
        //2修改车辆状态
        customerDao.updateCarstate(returnCarPo);
        //3计算价格
        //3.1取出价格
        BigDecimal price =new BigDecimal(customerDao.findPriceByNO(returnCarPo.getCarNo()));
        //3.2取出所用时长
        Long oderTimeByid = customerDao.findOderTimeByid(returnCarPo.getId());
        BigDecimal oderTime = new BigDecimal(oderTimeByid);
        //3.4计算结果
        BigDecimal resultval=new BigDecimal(0);
        try {
            BigDecimal result = oderTime.divide(new BigDecimal(86400), 5, BigDecimal.ROUND_HALF_EVEN);
            resultval = (price.multiply(result)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }catch (ArithmeticException a){
            //数量过小什么都不搞
        }
        //4添加订单价格
        customerDao.updateOrderPrice(returnCarPo.getId(),resultval.doubleValue());
        return "合计:"+resultval+"元";
    }

    /**
     * 查询所有普通用户
     * @return
     */
    @Override
    public List<UserPo> findAllUser() {
        return userDao.findAllUser();
    }

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @Override
    public int deleteUserByid(Integer id) {
        return userDao.deleteUserByid(id);
    }

}
