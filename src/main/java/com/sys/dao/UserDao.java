package com.sys.dao;

import com.sys.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {
    User login(String username);
}
