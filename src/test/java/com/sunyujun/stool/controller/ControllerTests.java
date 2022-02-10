package com.sunyujun.stool.controller;

import com.sunyujun.stool.mapper.RegisterMapper;
import com.sunyujun.stool.pojo.Item;
import com.sunyujun.stool.pojo.User;
import com.sunyujun.stool.service.RegisterService;
import com.sunyujun.stool.service.impl.RegisterServiceImpl;
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

    @Autowired
    private RegisterService registerService;


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
        List<Item> items = itemController.getItemList(null, null, 1);
        System.out.println(items);
    }

    @Test
    void testUpdateAll(){
        List<Item> itemList = itemController.getItemList(null, null, 1);
        Item item = itemList.get(0);
        item.setTitle(item.getTitle() + "new ");

//        itemController.updateAll(itemList, 1);
    }

    @Test
    void testCheckDupName(){
        boolean sun = registerController.checkDupName("sun");
        assert sun;
        boolean none = registerController.checkDupName("none");
        assert !none;
    }

    @Test
    void testCheckDupNameService(){
        System.out.println(registerService.searchForUsername("none"));
        // null
    }

}
