package com.sys.check;

import org.thymeleaf.util.TextUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/24
 **/
public class IsCarnumberNO {
    public static boolean isCarNo(String carNo){
        Pattern p = compile("^[京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(?:(?![A-Z]{4})[A-Z0-9]){4}[A-Z0-9挂学警港澳]{1}$");
            Matcher m = p.matcher(carNo);
                if (!m.matches()){
                    return false;
                }
                return true;
        }
}
