package com.sunyujun.stool.service;

import com.sunyujun.stool.pojo.Item;

import java.util.List;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/12 18:42
 */
public interface ItemService {

    List<Item> getItemsByUserId(Integer userId);

    int removeItemById(String itemId);

    void removeItems(List<Item> itemList);

    int saveItem(Item item);

    boolean saveItems(List<Item> itemList);

    int updateItemOnId(Item item);

    boolean updateAll(List<Item> itemList, Integer userId);

}
