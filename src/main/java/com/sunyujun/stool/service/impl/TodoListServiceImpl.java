package com.sunyujun.stool.service.impl;

import com.sunyujun.stool.mapper.TodoListMapper;
import com.sunyujun.stool.pojo.Item;
import com.sunyujun.stool.service.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/12 16:11
 */
@Deprecated
@Service
public class TodoListServiceImpl implements TodoListService {

    @Autowired
    private TodoListMapper todoListMapper;

    @Override
    public List<Item> getItemListByUserId(String userId) {
        return todoListMapper.getItemListByUserId(userId);
    }
}
