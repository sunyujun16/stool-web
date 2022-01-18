package com.sunyujun.stool.service;

import com.sunyujun.stool.pojo.Item;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/12 18:42
 */
public interface ItemService {

    List<Item> getItemsByUserId(Integer userId);
}
