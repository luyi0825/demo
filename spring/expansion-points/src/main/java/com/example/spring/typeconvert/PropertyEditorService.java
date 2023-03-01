package com.example.spring.typeconvert;

import org.springframework.beans.SimpleTypeConverter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class PropertyEditorService implements InitializingBean {

    @Value("abc")
    private User user;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(user);
        SimpleTypeConverter typeConverter = new SimpleTypeConverter();
        typeConverter.registerCustomEditor(User.class, new StringToUserPropertyEditor1());
        User value = typeConverter.convertIfNecessary("1", User.class);
        System.out.println(value);

        SimpleTypeConverter typeConverter2 = new SimpleTypeConverter();

        DefaultConversionService conversionService = new DefaultConversionService();
        typeConverter2.setConversionService(conversionService);
         value = typeConverter.convertIfNecessary("2", User.class);
        System.out.println(value);


    }
}
