package com.sys.controller;

import com.sys.Utlis.BigDecimalUtil;
import com.sys.Utlis.DateUtil;
import com.sys.Utlis.ParameterCalibration;
import com.sys.entity.CarPo;
import com.sys.service.CarService;
import com.sys.vo.CarVo;
import com.sys.vo.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
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
        CarPo carPo = new CarPo();
        boolean carNocomparresult = carNocompar(carVo.getCarNo());
        if (!carNocomparresult){
            status.setStatus(3);
            return status;
        }
        boolean insertroreult = insertRo(carVo.getCarNo(), carVo.getCarColor(), carVo.getCarBuyTime(),
                carVo.getCarEngineNo(), carVo.getCarFrameNo(), carVo.getCarFuelNo(), carVo.getRecordCreator(),carVo.getCarPrice(),carVo.getCarName());
        if(!insertroreult){
            status.setStatus(2);
            return status;
        }
        boolean MatchingResultsa = ParameterCalibration.carNo(carVo.getCarNo());
        boolean MatchingResultsb = ParameterCalibration.conpileDate(carVo.getCarBuyTime());
        boolean aDouble = ParameterCalibration.isDouble(carVo.getCarPrice());
        if (!(MatchingResultsb&&MatchingResultsa&&aDouble)){
            status.setStatus(2);
            return status;
        }
        String a = carVo.getCarBuyTime();
        Date carBuyTime = DateUtil.stringTOdate(a);
        BigDecimal CarPrice = BigDecimalUtil.StringtoBigDecimal(carVo.getCarPrice());
        updateRo(carPo,carVo,carBuyTime,CarPrice);
        int rows = carService.insertCar(carPo);
        status.setStatus(rows);
        return  status;
    }

    @RequestMapping("/updateCar")
    public Status updateCar(CarVo carVo){
        Status status = new Status();
        if(!carNocompar(carVo.getCarNo())){
            status.setStatus(3);
            return status;
        }
        if(carVo.getCarBuyTime().equals("")){
            //如果为空不校验
        }else {
            boolean MatchingResults = ParameterCalibration.conpileDate(carVo.getCarBuyTime());
            if (!(MatchingResults)){
                status.setStatus(2);
                return status;
            }
        }
        if(carVo.getCarNo().equals("")){
            //如果为空不校验
        }else {
            boolean MatchingResultsb = ParameterCalibration.carNo(carVo.getCarNo());
            if (!(MatchingResultsb)){
                status.setStatus(2);
                return status;
            }
        }
        if(carVo.getCarBuyTime().equals("")){
            CarPo carpo = carService.findById(carVo.getId());
            Date carBuyTime = carpo.getCarBuyTime();
            CarPo carPo = new CarPo();
            BigDecimal carPrice = new BigDecimal(0);
            if(carVo.getCarPrice().equals("")){
                carPrice = carpo.getCarPrice();
            }else {
                 carPrice = BigDecimalUtil.StringtoBigDecimal(carVo.getCarPrice());
            }
            updateRo(carPo,carVo,carBuyTime,carPrice);
            int rows = carService.updeteCar(carPo);
            status.setStatus(rows);
        }else {
            String carBuyTimestr = carVo.getCarBuyTime();
            Date carBuyTime = new Date(carBuyTimestr);
            CarPo carPo = new CarPo();
            BigDecimal carPrice = new BigDecimal(0);
            if(carVo.getCarPrice().equals("")){
                CarPo carpo = carService.findById(carVo.getId());
                carPrice = carpo.getCarPrice();
            }else {
                carPrice = BigDecimalUtil.StringtoBigDecimal(carVo.getCarPrice());
            }
            updateRo(carPo,carVo,carBuyTime,carPrice);
            int rows = carService.updeteCar(carPo);
            status.setStatus(rows);
        }
        return  status;
    }
    @RequestMapping("/findById")
    public CarVo updateCar(Integer id){
        CarVo carVo = new CarVo();
        CarPo carPo = carService.findById(id);
        String carBuyTime = DateUtil.DateFormat(carPo.getCarBuyTime());
        String carprice = BigDecimalUtil.bigDecimaltoString(carPo.getCarPrice());
        carVo.setCarNo(carPo.getCarNo()).setCarColor(carPo.getCarColor())
                .setCarBuyTime(carBuyTime).setCarEngineNo(carPo.getCarEngineNo())
                .setCarFuelNo(carPo.getCarFuelNo()).setCarFrameNo(carPo.getCarFrameNo())
                .setCarStatus(carPo.getCarStatus()).setState(carPo.getState()).setCarName(carPo.getCarName()).setCarPrice(carprice);
        return carVo;
    }

    /**
     * 修改车辆入参处理
     */
    void updateRo(CarPo carPo, CarVo carVo, Date carBuyTimestr, BigDecimal CarPrice){
        String carNo = carVo.getCarNo();
        String carColor = carVo.getCarColor();
        String carEngineNo = carVo.getCarEngineNo();
        String carFrameNo = carVo.getCarFrameNo();
        String carFuelNo = carVo.getCarFuelNo();
        String carStatus = carVo.getCarStatus();
        Integer state = carVo.getState();
        String carName = carVo.getCarName();
        Integer id = carVo.getId();
        String recordCreator = carVo.getRecordCreator();
        carPo.setCarNo(carNo).setCarColor(carColor).setCarEngineNo(carEngineNo).setCarBuyTime(carBuyTimestr).setCarFrameNo(carFrameNo).
                setCarFuelNo(carFuelNo).setCarStatus(carStatus).setState(state).setId(id).setCarPrice(CarPrice).setCarName(carName).setRecordCreator(recordCreator);

    }
    /**
     * 新增车辆非空校验
     *
     */
    boolean insertRo(String carNo, String carColor, String carBuyTime, String
            carEngineNo, String carFrameNo, String carFuelNo, String recordor, String carName, String carPrice){

        if(carNo.equals("")&&carColor.equals("")&&carBuyTime.equals("")&&carEngineNo.equals("")
            &&carFrameNo.equals("")&&carFuelNo.equals("")&&recordor.equals("")&&carName.equals("")&&carPrice.equals("")){
            return false;
        }
        return true;
    }
    /**
     * 车牌号查重
     */
    boolean carNocompar(String carNo){
        int a=0;
        ArrayList<CarVo> carAll = carService.findCarAll();
        for (CarVo carVo : carAll) {
            if (carVo.getCarNo().equals(carNo)){
                 a=1;
                break;
            }
        }
        if (a==1){
            return false;
        }else {
            return true;
        }
    }
}
