package com.test.mybatis.batch.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.test.mybatis.batch.domain.TUser;
import com.test.mybatis.batch.mapper.TUserMapper;
import com.test.mybatis.batch.service.TUserService;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2022-09-06 13:55:12
*/
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser>
    implements TUserService {

}




