package com.example.spring.event;


import org.springframework.context.event.EventListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * 事件监听器-基于注解
 *
 * @author luyi
 */
@Component
public class MyEventListener2 {

    @EventListener
    public void process(@NonNull MyEvent event) {
        System.out.println("MyEventListener2:" + event.getStr());
    }

}
