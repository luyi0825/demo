package com.example.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * 事件监听器-基于接口
 *
 * @author luyi
 */
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {
    @Override
    public void onApplicationEvent(@NonNull MyEvent event) {
        System.out.println("MyEventListener:" + event.getStr());
    }
}
