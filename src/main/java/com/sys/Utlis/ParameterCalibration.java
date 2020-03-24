package com.sys.Utlis;

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
}
