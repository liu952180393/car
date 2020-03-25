package com.sys.dao;

import com.sys.entity.UserPo;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    /*用户登录*/
    UserPo login(String username);
}
