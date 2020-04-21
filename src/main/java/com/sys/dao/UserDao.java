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

    /**
     * 修改密码
     */
    int updatePassword(String password, String username);
    /**
     * 根据密码查询用户
     */
    UserPo findByUsername(String usernmae);
    /**
     * 注册用户
     */
    int addUser(UserPo userPo);

    /**
     * 查询所有普通用户
     * @return
     */
    List<UserPo> findAllUser();

    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    int deleteUserByid(Integer id);
}
