package com.demo.shardingjdbc;

import com.demo.shardingjdbc.dao.UserDao;
import com.demo.shardingjdbc.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

/**
 * redis测试启动类
 *
 * @author luyi
 */
@SpringBootApplication(scanBasePackages = "com.demo.shardingjdbc.dao")
//@MapperScan( basePackages= {"com.demo.shardingjdbc.dao"})
public class ShardingJdbcStater implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcStater.class, args);
    }

    @Autowired
    private UserDao userDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setUsername("username" + UUID.randomUUID());
        user.setPassword("password" + UUID.randomUUID());
        user.setMail("893431435@qq.com");
        userDao.insert(user);
    }
}
