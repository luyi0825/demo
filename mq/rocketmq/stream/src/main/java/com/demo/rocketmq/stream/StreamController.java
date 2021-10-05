package com.demo.rocketmq.stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luyi
 */
@RestController
@RequestMapping("/mqStream")
public class StreamController {

    @Autowired
    private StreamBridge streamBridge;


    @RequestMapping("/{bindingName}/{message}")
    public void send(@PathVariable(name = "bindingName") String bindingName,@PathVariable(name="message") String message) {
        streamBridge.send(bindingName, message);
    }

}
