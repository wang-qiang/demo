package com.wq.demo;

import com.wq.demo.dao.UserDao;
import com.wq.demo.repo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.Assert;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class IndexCtrlTest extends BaseTest {

    @Autowired
    UserDao userDao;

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testGetUser() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/users");
        requestBuilder.headers(getHttpHeaders());
        mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
        .andExpect(jsonPath("$[0].name").value("lisi"));

        List<User> users = userDao.findAll();
        Assert.isTrue(2 == users.size(), "User length not equal");
    }
}
