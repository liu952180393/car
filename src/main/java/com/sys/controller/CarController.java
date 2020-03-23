package com.sys.controller;

import com.sys.dao.CarDao;
import com.sys.entity.Car;
import com.sys.service.CarService;
import com.sys.vo.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/19
 **/
@RestController
public class CarController {
    @Autowired
    private CarService carService;
    @RequestMapping("/findAll")
    public List<Car> findAllCar(){
        List<Car> list = carService.findCarById();
        for (Car car : list) {
            System.out.println(car);
        }
        return list;
    }

    @RequestMapping("/deleteCar")
    public Status deleteCar(Integer id){
        int rows = carService.deleteById(id);
        Status status = new Status();
        status.setStatus(rows);
        return  status;
    }

    @RequestMapping("/insertCar")
    public Status insertCar(Car car){
        int rows = carService.insertCar(car);
        Status status = new Status();
        status.setStatus(rows);
        return  status;
    }

    @RequestMapping("/updateCar")
    public Status updateCar(Car car){
        int rows = carService.updeteCar(car);
        Status status = new Status();
        status.setStatus(rows);
        return  status;
    }
}
