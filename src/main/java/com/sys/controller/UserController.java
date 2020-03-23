package com.sys.controller;

import com.sys.entity.User;
import com.sys.service.UserService;
import com.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
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

}
