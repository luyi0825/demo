package com.example.spring.event;

import org.springframework.context.ApplicationEvent;


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
