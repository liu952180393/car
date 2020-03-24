package com.sys.controller;

import com.sys.Utlis.DateUtil;
import com.sys.Utlis.ParameterCalibration;
import com.sys.entity.Car;
import com.sys.service.CarService;
import com.sys.vo.CarVo;
import com.sys.vo.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

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
    public ArrayList<CarVo> findAllCar(){
        ArrayList<CarVo> list = carService.findCarAll();

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
    public Status insertCar(CarVo carVo) throws ParseException {
        Status status = new Status();
        Car car = new Car();
        boolean insertroreult = insertRo(carVo.getCarNo(), carVo.getCarColor(), carVo.getCarBuyTime(),
                carVo.getCarEngineNo(), carVo.getCarFrameNo(), carVo.getCarFuelNo(), carVo.getRecordCreator());
        if(insertroreult){
            status.setStatus(2);
            return status;
        }
        boolean MatchingResultsa = ParameterCalibration.carNo(carVo.getCarNo());
        boolean MatchingResultsb = ParameterCalibration.conpileDate(carVo.getCarBuyTime());
        if (!(MatchingResultsb&&MatchingResultsa)){
            status.setStatus(2);
            return status;
        }
        Date carBuyTime = DateUtil.stringTOdate(carVo.getCarBuyTime());
        updateRo(car,carVo,carBuyTime);
        int rows = carService.insertCar(car);
        status.setStatus(rows);
        return  status;
    }

    @RequestMapping("/updateCar")
    public Status updateCar(CarVo carVo){
        Status status = new Status();
        boolean MatchingResults = ParameterCalibration.conpileDate(carVo.getCarBuyTime());
        if (!MatchingResults){
            status.setStatus(2);
            return status;
        }
        if(carVo.getCarBuyTime().equals("")){
            Car carpo = carService.findById(carVo.getId());
            Date carBuyTime = carpo.getCarBuyTime();
            Car car = new Car();
            updateRo(car,carVo,carBuyTime);
            int rows = carService.updeteCar(car);
            status.setStatus(rows);
        }else {
            String carBuyTimestr = carVo.getCarBuyTime();
            Date carBuyTime = new Date(carBuyTimestr);
            Car car = new Car();
            updateRo(car,carVo,carBuyTime);
            int rows = carService.updeteCar(car);
            status.setStatus(rows);
        }
        return  status;
    }
    @RequestMapping("/findById")
    public CarVo updateCar(Integer id){
        CarVo carVo = new CarVo();
        Car car = carService.findById(id);
        String carBuyTime = DateUtil.DateFormat(car.getCarBuyTime());
        carVo.setCarNo(car.getCarNo()).setCarColor(car.getCarColor())
                .setCarBuyTime(carBuyTime).setCarEngineNo(car.getCarEngineNo())
                .setCarFuelNo(car.getCarFuelNo()).setCarFrameNo(car.getCarFrameNo())
                .setCarStatus(car.getCarStatus()).setState(car.getState());
        return carVo;
    }

    /**
     * 修改车辆入参处理
     */
    void updateRo(Car car,CarVo carVo,Date carBuyTimestr){
        String carNo = carVo.getCarNo();
        String carColor = carVo.getCarColor();
        String carEngineNo = carVo.getCarEngineNo();
        String carFrameNo = carVo.getCarFrameNo();
        String carFuelNo = carVo.getCarFuelNo();
        String carStatus = carVo.getCarStatus();
        Integer state = carVo.getState();
        Integer id = carVo.getId();
        car.setCarNo(carNo).setCarColor(carColor).setCarEngineNo(carEngineNo).setCarBuyTime(carBuyTimestr).setCarFrameNo(carFrameNo).setCarFuelNo(carFuelNo).setCarStatus(carStatus).setState(state).setId(id);

    }
    /**
     * 新增车辆非空校验
     *
     */
    boolean insertRo(String carNo, String carColor, String carBuyTime, String
            carEngineNo, String carFrameNo, String carFuelNo, String recordor){
        if(carNo.equals("")&&carColor.equals("")&&carBuyTime.equals("")&&carEngineNo.equals("")
            &&carFrameNo.equals("")&&carFuelNo.equals("")&&recordor.equals("")){
            return false;
        }
        return true;
    }
}
