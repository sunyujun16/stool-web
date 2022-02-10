package com.sunyujun.stool.service.impl;

import com.sunyujun.stool.mapper.ItemsMapper;
import com.sunyujun.stool.pojo.Item;
import com.sunyujun.stool.service.ItemService;
import org.apache.ibatis.transaction.TransactionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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

    @Override
    public int removeItemById(String itemId) {
        return itemsMapper.removeItemById(itemId);
    }

    @Transactional
    @Override
    public void removeItems(List<Item> itemList) {
        for (Item item : itemList) {
            if (itemsMapper.removeItemById(item.getId()) <= 0) {
                throw new TransactionException("删除items出错");
            }
        }
    }

    @Override
    public int saveItem(Item item) {
        return itemsMapper.saveItem(item);
    }

    @Transactional
    @Override
    public boolean saveItems(List<Item> itemList) {
        for (Item item : itemList) {
            if (itemsMapper.saveItem(item) <= 0) {
                throw new TransactionException("删除items出错");
            };
        }
        return true;
    }

    @Override
    public int updateItemOnId(Item item) {
        return itemsMapper.updateItemOnId(item);
    }

    @Transactional
    @Override
    public boolean updateAll(List<Item> itemList, Integer userId) {
        Objects.requireNonNull(itemList,"列表不存在");
        // 删掉所有, 可能有异常抛出，但是到底需不需要Transactional注解呢？尽管Mapper只有一条语句，不需要回滚。
        // 但是由于后面saveItems仍有可能失败，所以注解还是需要滴。
        itemsMapper.removeItemsByUserId(userId);
        // 再添加所有
        if (itemList.size() > 0) saveItems(itemList);
        return true;
    }



}
