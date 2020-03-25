package com.sys.entity;

import lombok.Data;

@Data
public class UserPo {
    private int id;
    private String username;
    private String password;
    private int state;
}
