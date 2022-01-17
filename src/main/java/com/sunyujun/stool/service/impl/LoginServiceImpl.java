package com.sunyujun.stool.service.impl;

import com.sunyujun.stool.mapper.LoginMapper;
import com.sunyujun.stool.pojo.User;
import com.sunyujun.stool.service.LogInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/16 19:37
 */
@Service
public class LoginServiceImpl implements LogInService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User getUserByLogin(String userName, String passWord) {
        return loginMapper.getUserByLogin(userName, passWord);
    }
}
