package com.sys.Utlis;

import java.text.ParseException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * 描述：
 *
 * @author PuYinsheng
 * @date 2020/3/24
 * @copyright 2020 [图片]www.tydic.com Inc. All rights reserved.
 * 注意：本内容仅限于北京天源迪科信息技术有限公司内部传阅，禁止外泄以及用于其他商业目的.
 **/
public class ParameterCalibration {
    public static boolean carNo(String carNumber){
        Pattern p = compile("^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(?:(?![A-Z]{4})[A-Z0-9]){4}[A-Z0-9挂学警港澳]{1}$");
        Matcher m = p.matcher(carNumber);
        if (!m.matches()){
            return false;
        }
        return true;
    }
    public  static boolean conpileDate(String datastr){
        Pattern p =compile("\\d{4}(\\-|\\/|.)\\d{1,2}\\1\\d{1,2}");
        Matcher m = p.matcher(datastr);
        if (!m.matches()) {
            return  false;
        }
        return true;
    }

    /**
     * 判断字符串是否能转换为double
     * @param string
     * @return
     */
    public static boolean isDouble(String string){
        boolean result=true;
        try{
            Double.parseDouble(string);
        }catch (Exception e){
            result=false;
        }
        return result;
    }
    /**
     * 校验日期字符串格式是否为yyyy/MM/dd
     * @param dateString
     * @return
     */
    public static boolean checkDateString(String dateString){
        Pattern pattern = compile("[1-2][0-9]{3}\\/[0|1]+[1-9]+\\/[0-3]+[1-9]+");
        Matcher matcher = pattern.matcher(dateString);
        return matcher.find();
    }

    /**
     * 邮箱校验
     * @param dateString
     * @return
     */
    public static boolean checkEmail(String dateString){
        Pattern pattern = compile("\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}");
        Matcher matcher = pattern.matcher(dateString);
        return matcher.find();
    }

    /**
     * 身份证号驾照号校验
     * @param dateString
     * @return
     */
    public static boolean checkNoOrCarOn(String dateString){
        Pattern pattern = compile("\\d{17}[\\d|x]|\\d{15}");
        Matcher matcher = pattern.matcher(dateString);
        return matcher.find();
    }

    /**
     * 校验驾龄
     * @param dateString
     * @return
     */
    public static boolean checkDriverAge(Double dateString){
        String agestr = String.valueOf(Double.valueOf(dateString));
        Pattern pattern = compile("[1-9]\\d*.\\d*|0.\\d*[1-9]\\d*");
        Matcher matcher = pattern.matcher(agestr);
        return matcher.find();
    }

    /**
     * 校验驾照发证(到期)日期
     * @param cuetomerLicenseStartDate 发
     * @param cuetomerLicenseInvalidDate 到
     * @return
     */
    public static boolean checkCarCard(String cuetomerLicenseStartDate,String cuetomerLicenseInvalidDate){
        Date cuetomerLicenseStartDateval= new Date();
        Date cuetomerLicenseInvalidDateval=new Date();
        try {
             cuetomerLicenseStartDateval = DateUtil.stringTOdate(cuetomerLicenseStartDate);
             cuetomerLicenseInvalidDateval = DateUtil.stringTOdate(cuetomerLicenseInvalidDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int result = cuetomerLicenseStartDateval.compareTo(cuetomerLicenseInvalidDateval);
        if(result==-1){
            return true;
        }else {
            return false;
        }
    }

    /**
     * 校验电话号码
     * @param dateString
     * @return
     */
    public static boolean checTel(String dateString){
        Pattern pattern = compile("[0-9-()（）]{7,18}");
        Matcher matcher = pattern.matcher(dateString);
        return matcher.find();
    }
}
