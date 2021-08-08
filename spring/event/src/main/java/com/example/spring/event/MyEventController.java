package com.example.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyi
 * 事件发送器
 */
@RestController
@RequestMapping("/spring/event")
public class MyEventController {

    @Autowired
    private MyEventPublisher myEventPublisher;

    @RequestMapping("/send/{str}")
    public String send(@PathVariable(name = "str") String str) {
        MyEvent myEvent = new MyEvent(this, str);
        myEventPublisher.sendEvent(myEvent);
        return str;
    }

}
