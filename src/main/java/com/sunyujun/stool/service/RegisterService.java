package com.sunyujun.stool.service;

import com.sunyujun.stool.pojo.User;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/16 20:24
 */
public interface RegisterService {
    int registerNormalUser(User user);

    String searchForUsername(String username);
}
