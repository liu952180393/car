package com.sys.service;

import com.sys.entity.Car;

import java.util.List;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/19
 **/
public interface CarService {
    List<Car> findCarById();
    int updateCar(Car car);
}
