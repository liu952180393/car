package com.sys.controller;

import com.sys.dao.UserDao;
import com.sys.entity.UserPo;
import com.sys.service.CustomerService;
import com.sys.service.UserService;
import com.sys.vo.Status;
import com.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
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
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;
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
    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @RequestMapping("deleteUserByid")
    public int deleteUserByid(Integer id) {
        return customerService.deleteUserByid(id);
    }
    /**
     * 查询所有普通用户
     * @return
     */
    @RequestMapping("findAllUser")
    public List<UserPo> findAllUser() {
        return customerService.findAllUser();
    }
}
