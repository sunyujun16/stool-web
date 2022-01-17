package com.sunyujun.stool.pojo;

import lombok.Data;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/16 17:03
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String privilege;
}
