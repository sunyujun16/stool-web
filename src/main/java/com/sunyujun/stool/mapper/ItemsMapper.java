package com.sunyujun.stool.mapper;

import com.sunyujun.stool.pojo.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/12 16:37
 */
@Mapper
public interface ItemsMapper {

    List<Item> getItemsByUserId(Integer userId);

    int removeItemById(String itemId);

    // 没必要，批量删除封装在Service里面即可，Controller调用。
//    int deleteItemsByUserId(Integer userId);

    int saveItem(Item item);

    int updateItemOnId(Item item);

    int removeItemsByUserId(Integer userId);




}
