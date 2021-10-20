package com.demo.cloud.webclient.consumer;

import com.demo.could.alibaba.nacos.loadbalance.NacosWeightLoadBalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;


/**
 * @author luyi
 * webClient服务消费端
 */
@SpringBootApplication
@LoadBalancerClients(defaultConfiguration = {NacosWeightLoadBalanceConfig.class})
public class RestTemplateConsumerStarter {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(RestTemplateConsumerStarter.class);
        springApplication.run(args);
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder loadBalancedWebClientBuilder() {
        return WebClient.builder();
    }
}
