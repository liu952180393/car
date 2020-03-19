package com.sys.service.serviceImpl;

import com.sys.dao.UserDao;
import com.sys.entity.User;
import com.sys.service.UserService;
import com.sys.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserVo login(String username,String password) {
        UserVo userVo = new UserVo();
        User userlogin = userDao.login(username);
        if ((password==null)&& (username==null)){
            userVo.setStatus(2);
        }
        else if(password.equals(userlogin.getPassword())){
            userVo.setStatus(1);
            userVo.setState(userlogin.getState());
        }else {
            userVo.setStatus(2);
        }
        return userVo;
    }
}
