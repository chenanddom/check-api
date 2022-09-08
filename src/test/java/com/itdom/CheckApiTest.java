package com.itdom;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.annotation.Resource;


//定义为随机端口，避免多服务端口冲突
@SpringBootTest(classes = {CheckApiApplication.class},webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CheckApiTest {
    @Resource
    private MockMvc mockMvc;
    @Test
    @DisplayName("检测api接口")
    public void checkApi() throws Exception {
        MvcResult phone = mockMvc.perform(MockMvcRequestBuilders.get("/checkApi/getByPhone")
                .param("phone", "18039306931"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("SUCCES1S:"+"18039306931"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

    }
    @Test
    @DisplayName("添加用户的接口")
    public void addUserTest() throws Exception {
        MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("id",System.currentTimeMillis()+"");
        multiValueMap.add("username","张三");
        multiValueMap.add("age","20");

        MvcResult aTrue = mockMvc.perform(MockMvcRequestBuilders.post("/checkApi/addUser")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":\"1662598487138\",\"username\":\"张三\",\"age\":20}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string("true"))
                .andReturn();
    }
    @Test
    public void test(){
        MultiValueMap<String,String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("id",System.currentTimeMillis()+"");
        multiValueMap.add("username","张三");
        multiValueMap.add("age","20");
        try {
            System.out.println(new ObjectMapper().writeValueAsString(multiValueMap));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
