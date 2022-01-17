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

    List<Item> getItemsByUserId(String userId);
}
