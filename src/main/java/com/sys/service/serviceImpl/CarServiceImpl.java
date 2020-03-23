package com.sys.service.serviceImpl;

import com.sys.dao.CarDao;
import com.sys.entity.Car;
import com.sys.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<Car> findCarById() {
        List<Car> list = carDao.findCarById();
        return list;
    }

    @Override
    public int updateCar(Car car) {
        int rows = carDao.updateCar(car);
        return rows;
    }
}
