package com.sunyujun.stool.service.impl;

import com.sunyujun.stool.mapper.ItemsMapper;
import com.sunyujun.stool.pojo.Item;
import com.sunyujun.stool.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/12 18:43
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public List<Item> getItemsByUserId(Integer userId) {
        return itemsMapper.getItemsByUserId(userId);
    }
}
