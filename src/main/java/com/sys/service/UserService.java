package com.sys.service;

import com.sys.vo.UserVo;

public interface UserService {
    UserVo login(String username,String password);

}
