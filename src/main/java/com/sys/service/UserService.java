package com.sys.service;

import com.sys.entity.User;
import com.sys.vo.UserVo;

public interface UserService {
    UserVo login(String username,String password);

}
