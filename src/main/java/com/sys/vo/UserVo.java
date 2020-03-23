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
    /**
     * //判断登录成功与否
     */
    private int status=2;
    /**
     * //用户身份
     */
    private int state;
}
