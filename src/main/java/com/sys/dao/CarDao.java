package com.sys.dao;

import com.sys.entity.CarPo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liu
 */
@Repository
public interface CarDao {
    List<CarPo> findCarAll();
    int deleteById(Integer id);
    int insertCar(CarPo carPo);
    int updateCar(CarPo carPo);
    CarPo findById(Integer id);

}
