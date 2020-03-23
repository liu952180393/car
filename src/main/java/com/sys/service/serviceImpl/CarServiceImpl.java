package com.sys.service.serviceImpl;

import com.sys.dao.CarDao;
import com.sys.entity.Car;
import com.sys.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
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

    //查询所有车辆信息
    @Override
    public List<Car> findCarById() {
        List<Car> list = carDao.findCarById();
        Iterator<Car> iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).setNumber(i+1);
        }
        return list;
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
}
