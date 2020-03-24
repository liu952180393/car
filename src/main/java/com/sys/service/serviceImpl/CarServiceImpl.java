package com.sys.service.serviceImpl;

import com.sys.Utlis.BigDecimalUtil;
import com.sys.Utlis.DateUtil;
import com.sys.dao.CarDao;
import com.sys.entity.Car;
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
        List<Car> list = carDao.findCarAll();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setNumber(i+1);
        }
        for (Car car : list) {
            CarVo carVo = new CarVo();
            String carBuyTime = DateUtil.DateFormat(car.getCarBuyTime());
            String RecordCreateTime= DateUtil.DateFormat(car.getRecordCreateTime());
            carVo.setCarBuyTime(carBuyTime).setRecordCreateTime(RecordCreateTime);
            carVo.setCarPrice(BigDecimalUtil.bigDecimaltoString(car.getCarPrice()));
            carVo.setId(car.getId()).setNumber(car.getNumber()).setCarNo(car.getCarNo())
                    .setCarColor(car.getCarColor()).setCarEngineNo(car.getCarEngineNo())
                    .setCarFrameNo(car.getCarFrameNo()).setCarFuelNo(car.getCarFuelNo())
                    .setCarStatus(car.getCarStatus()).setState(car.getState()).setRecordCreator(car.getRecordCreator()).setCarName(car.getCarName());
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
    public int insertCar(Car car) {
        int rows = carDao.insertCar(car);
        return rows;
    }
    //修改车辆信息
    @Override
    public int updeteCar(Car car) {
        return carDao.updateCar(car);
    }

    @Override
    public Car findById(Integer id) {
        return carDao.findById(id);
    }
}
