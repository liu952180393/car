package com.sys.dao;

import com.sys.entity.UserPo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    /*用户登录*/
    UserPo login(String username);
    /**
     * 查询全部用户
     */
    List<UserPo> findUserAll();
}
