package com.demo.mybatis.son.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author luyi
 *
 */
@Data
public class User implements Serializable {

    private int id;
    private String name;
}
