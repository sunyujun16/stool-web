package com.sunyujun.stool.controller;

import com.sunyujun.stool.pojo.Item;
import com.sunyujun.stool.pojo.ItemList;
import com.sunyujun.stool.service.impl.ItemServiceImpl;
import com.sunyujun.stool.service.impl.TodoListServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/11 19:51
 */
@RestController
public class ItemController {

    @Autowired
    private ItemServiceImpl  itemService;

    @CrossOrigin
    @RequestMapping("/test")
    public List<Item> testGetItemList(HttpServletResponse response, HttpServletRequest request,
                                    @RequestParam(value = "userId", defaultValue = "001") String userId) {

        HttpSession session = request.getSession();
        System.out.println("test ------- "+session.getId());
        return itemService.getItemsByUserId(userId);
    }


}
