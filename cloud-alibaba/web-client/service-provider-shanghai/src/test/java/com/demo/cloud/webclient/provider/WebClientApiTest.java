package com.demo.cloud.webclient.provider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class WebClientApiTest {
    @Autowired
    private MockMvc mockMvc;
    private static final String API = "/webClientApi";


    @Test
    void sayHello() throws Exception {
        //没有参数的校验
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(API + "/sayHello");//.param("test", "a54");
        String str = mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        Assertions.assertNotNull(str);
        System.out.println(str);
    }
}