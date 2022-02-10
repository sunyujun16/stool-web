package com.sunyujun.stool.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/3 20:13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {
    private String id;
    private String username;
    private Integer userId;
    private String title;
    private Boolean done;
    private Long createTime;

}
