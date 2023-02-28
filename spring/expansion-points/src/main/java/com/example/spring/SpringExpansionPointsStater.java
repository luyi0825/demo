package com.example.spring;

import com.example.spring.typeconvert.StringToUserPropertyEditor;
import com.example.spring.typeconvert.User;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;


/**
 * spring拓展点启动类
 *
 * @author luyi
 */
@SpringBootApplication
public class SpringExpansionPointsStater {
    public static void main(String[] args) {
        new SpringApplication(SpringExpansionPointsStater.class).run(args);
    }

    @Bean
    public CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
        Map<Class<?>, Class<? extends PropertyEditor>> propertyEditorMap = new HashMap<>();

        // 表示StringToUserPropertyEditor可以将String转化成User类型，在Spring源码中，如果发现当前对象是String，而需要的类型是User，就会使用该PropertyEditor来做类型转化
        propertyEditorMap.put(User.class, StringToUserPropertyEditor.class);
        customEditorConfigurer.setCustomEditors(propertyEditorMap);
        return customEditorConfigurer;
    }
}
