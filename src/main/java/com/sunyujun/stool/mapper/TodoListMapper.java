package com.sunyujun.stool.mapper;

import com.sunyujun.stool.pojo.Item;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 获取TodoList，简单到不知该怎么描述了，哈哈。
 * @author sunyujun
 * @version 0.0.0
 * @date 1/12 7:56
 */
//@Component
@Mapper
public interface TodoListMapper {

    /**
     *
     * @param userId 是用户的ID，而不是Item的ID
     * @return java.util.List<com.sunyujun.stool.pojo.Item>
     * @author sunyujun
     * @date 1/12
     *
     */
    List<Item> getItemListByUserId(String userId);

}
