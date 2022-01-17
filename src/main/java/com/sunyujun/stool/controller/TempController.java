package com.sunyujun.stool.controller;

import com.sunyujun.stool.pojo.Item;
import com.sunyujun.stool.pojo.ItemList;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/9 20:50
 */
//@ConditionalOnMissingBean(TodoListController.class)
//@RestController
@Deprecated
public class TempController {

    @CrossOrigin
    @RequestMapping("/test")
    public ItemList testGetItemList(HttpServletResponse response) {
        ItemList itemList = new ItemList();
//        itemList.add(new Item("001", "eat", false));
//        itemList.add(new Item("002", "fuck", false));
//        itemList.add(new Item("003", "sleep", false));
        return itemList;
    }
}
