package com.dejing.miniprogram.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Resource;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {
  @Resource
  private MockMvc mockMvc;
//  @Autowired
//  private WebApplicationContext webApplicationContext;

//  @Before
//  public void setUp() throws Exception {
////    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
//    this.mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
//  }

  @After
  public void tearDown() throws Exception {}

  @Test
  public void user_login() {}

  @Test
  public void index() throws Exception {
    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/wx/index"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(print())
            .andReturn();
//            .getResponse()
//            .getContentAsString();
    //Assert.assertNotNull(mvcResult);
    System.out.println("Result === "+mvcResult.getResponse().getContentAsString());
    log.info(mvcResult.getResponse().getContentAsString());
  }

  @Test
  public void QRDdata() throws Exception {
    MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post("/wx/QRData")
            .param("code", "01,10,050001800111,32844484,216.98,20190327,72344545830540455708,333A")
            .param("date", (new Date()).toString())
            .header("content-type", "application/x-www-form-urlencoded"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(print())
            .andReturn();

    System.out.println("Result === "+mvcResult.getResponse().getContentAsString());
    log.info(mvcResult.getResponse().getContentAsString());
  }
}