package com.itdom;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
}
