package com.sunyujun.stool.controller;

import com.sunyujun.stool.pojo.Item;
import com.sunyujun.stool.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/17 9:45
 */
@SpringBootTest
public class ControllerTests {

    @Autowired
    private LoginRegisterController registerController;

    @Autowired
    private ItemController itemController;


    @Test
    public void testRegister(){
        // 个人感觉，凡是对数据库进行修改的测试，测试通过后还是注释掉为妙
//        User user = new User();
//        user.setUsername("sun");
//        user.setPassword("0");
//        registerController.registerNormalUser(user);
//
//        User user2 = new User();
//        user2.setUsername("吴老二");
//        user2.setPassword("502");
//        registerController.registerNormalUser(user2);
    }

    @Test
    void testItemList(){
        List<Item> items = itemController.testGetItemList(null, null, 1);
        System.out.println(items);
    }

}
