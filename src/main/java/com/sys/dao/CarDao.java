package com.sys.dao;

import com.sys.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liu
 */
@Repository
public interface CarDao {
    List<Car> findCarById();
    /*
    *修改车辆信息
    **/
    int updateCar(Car car);
}
