package com.demo.mybatis.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author luyi
 * 权限用户
 */
public class AuthUser implements Serializable {
    /**
     * 用户主键
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 最后登录ID
     */
    private String lastLoginIp;
    /**
     * 登录错误次数
     */
    private String errorCount;
    /**
     * 最后登录时间
     */
    private Date lastLoginTime;

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public String getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(String errorCount) {
        this.errorCount = errorCount;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", mail='" + mail + '\'' +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", errorCount='" + errorCount + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
