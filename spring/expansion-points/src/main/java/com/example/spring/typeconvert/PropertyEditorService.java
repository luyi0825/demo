package com.example.spring.typeconvert;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class PropertyEditorService implements InitializingBean {

    @Value("abc")
    private User user;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(user);
    }
}
