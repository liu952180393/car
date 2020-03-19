package com.sys.dao;

import com.sys.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /*用户登录*/
    User login(String username);
}
