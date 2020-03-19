package com.sys.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述：登录出参
 *
 * @author
 * @date 2020/3/19
 **/
@Data
public class UserVo implements Serializable{
    private int status;//判断登录成功与否
    private int state;//用户身份
}
