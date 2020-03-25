package com.sys.service.serviceImpl;

import com.sys.Utlis.BigDecimalUtil;
import com.sys.Utlis.DateUtil;
import com.sys.dao.CarDao;
import com.sys.entity.CarPo;
import com.sys.service.CarService;
import com.sys.vo.CarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/19
 **/
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    /**
     * 查询所有车辆信息
     * @return
     */
    @Override
    public ArrayList<CarVo> findCarAll() {
        ArrayList<CarVo> carVoArrayList = new ArrayList<>();
        List<CarPo> list = carDao.findCarAll();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setNumber(i+1);
        }
        for (CarPo carPo : list) {
            CarVo carVo = new CarVo();
            String carBuyTime = DateUtil.DateFormat(carPo.getCarBuyTime());
            String RecordCreateTime= DateUtil.DateFormat(carPo.getRecordCreateTime());
            carVo.setCarBuyTime(carBuyTime).setRecordCreateTime(RecordCreateTime);
            carVo.setCarPrice(BigDecimalUtil.bigDecimaltoString(carPo.getCarPrice()));
            carVo.setId(carPo.getId()).setNumber(carPo.getNumber()).setCarNo(carPo.getCarNo())
                    .setCarColor(carPo.getCarColor()).setCarEngineNo(carPo.getCarEngineNo())
                    .setCarFrameNo(carPo.getCarFrameNo()).setCarFuelNo(carPo.getCarFuelNo())
                    .setCarStatus(carPo.getCarStatus()).setState(carPo.getState()).setRecordCreator(carPo.getRecordCreator()).setCarName(carPo.getCarName());
            carVoArrayList.add(carVo);
        }


        return carVoArrayList;
    }
    //根据id删除车辆信息
    @Override
    public int deleteById(Integer id) {
        if(id==null || id<1){
            throw new IllegalArgumentException("id参数无效");
        }
        int rows = carDao.deleteById(id);

        return rows;
    }
    //新增车辆信息
    @Override
    public int insertCar(CarPo carPo) {
        int rows = carDao.insertCar(carPo);
        return rows;
    }
    //修改车辆信息
    @Override
    public int updeteCar(CarPo carPo) {
        return carDao.updateCar(carPo);
    }

    @Override
    public CarPo findById(Integer id) {
        return carDao.findById(id);
    }
}
