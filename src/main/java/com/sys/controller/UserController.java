package com.sys.controller;

import com.sys.entity.UserPo;
import com.sys.service.UserService;
import com.sys.vo.Status;
import com.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：
 *
 * @author
 * @date 2020/3/19
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/Login")
    public UserVo Login(String username,String password){
        UserVo userlogin = userService.login(username, password);
        return userlogin;
    }
    @RequestMapping("/findByPassword")
    public Status findByPassword(String username){
        UserPo user = userService.findByUsername(username);
        Status status = new Status();
        status.setStatus(0);
        if(user.getPassword()!=null){
            /**
             *
             * 查出有密码
             */
            status.setStatus(1);
        }
        return status;
    }
    @RequestMapping("/updatePassword")
    public Status updatePassword(String username, String password){
        int rows = userService.updatePassword(username,password);
        Status status = new Status();
        status.setStatus(0);
        if(rows == 1){
            status.setStatus(1);
        }
        return status;
    }
    @RequestMapping("/addUser")
    public Status addUser(UserPo userPo) {
        int rows = userService.addUser(userPo);
        Status status = new Status();
        status.setStatus(0);
        if (rows == 1) {
            /**
             * 注册成功
             */
            status.setStatus(1);
        }
        return status;
    }
}
