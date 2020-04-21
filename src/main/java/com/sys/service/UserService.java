package com.sys.service;

import com.sys.entity.UserPo;
import com.sys.vo.UserVo;

public interface UserService {
    UserVo login(String username, String password);

    int updatePassword(String password, String username);

    UserPo findByUsername(String username);

    int addUser(UserPo userPo);
}
