package com.sunyujun.stool.service;

import com.sunyujun.stool.pojo.User;
import com.sunyujun.stool.service.impl.LoginServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/16 19:39
 */
@SpringBootTest
public class ServiceTests {
    @Autowired
    private LoginServiceImpl loginService;

    @Test
    void testLoginServiceImpl(){
//        User sun = loginService.getUserByLogin("sun", "1");
//        assert null == sun;
//        sun = loginService.getUserByLogin("sun", "0");
//        assert "sun".equals(sun.getUserName());
    }
}
