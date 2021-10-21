package com.test.dubbo.provider;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class DubboMvcApiTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void sayHello() throws Exception {
        String url = "/dubboMvcApi/sayHello";
        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get(url).contentType(MediaType.TEXT_HTML_VALUE);
        String str = mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        Assertions.assertNotNull(str);
        System.out.println(str);
    }

}