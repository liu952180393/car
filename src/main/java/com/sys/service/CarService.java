package com.sys.service;

import com.sys.entity.Car;
import com.sys.vo.CarVo;

import java.util.ArrayList;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/19
 **/
public interface CarService {
    ArrayList<CarVo> findCarAll();

    int deleteById(Integer id);

    int insertCar(Car car);

    int updeteCar(Car car);

    Car findById(Integer id);
}
