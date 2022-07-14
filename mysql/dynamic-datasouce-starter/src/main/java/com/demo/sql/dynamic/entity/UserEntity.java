package com.demo.sql.dynamic.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @author luyi
 */
@TableName("t_user")
public class UserEntity implements Serializable {
    private Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
