package com.sunyujun.stool.service;

import com.sunyujun.stool.pojo.Item;

import java.util.List;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/12 16:10
 */
@Deprecated
public interface TodoListService {

    List<Item> getItemListByUserId(String userId);
}
