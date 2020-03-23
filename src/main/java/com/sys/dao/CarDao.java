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
    int deleteById(Integer id);
    int insertCar(Car car);
    int updateCar(Car car);

}
