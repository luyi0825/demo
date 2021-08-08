package com.example.spring.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ApplicationContextEvent;

/**
 * @author luyi
 */
public class MyEvent extends ApplicationEvent {
    private String str;

    public MyEvent(Object source, String str) {
        super(source);
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
