package com.sunyujun.stool.javabean;

import com.sunyujun.stool.pojo.Item;
import com.sunyujun.stool.pojo.User;
import lombok.Data;

import java.util.List;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 2/9 14:04
 */
@Data
public class UpdateBean {
    private List<Item> itemList;
    private Integer userId;
}
