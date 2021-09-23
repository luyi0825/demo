package com.test.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author luyi
 * 用户
 */
@Document(collection = "t_user")
@Data
public class User implements Serializable {
    @Id
    private String id;
    private String userName;
    private String password;
    private int age;
    private String sex;
}
