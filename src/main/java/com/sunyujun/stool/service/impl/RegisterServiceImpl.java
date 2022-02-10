package com.sunyujun.stool.service.impl;

import com.sunyujun.stool.mapper.RegisterMapper;
import com.sunyujun.stool.pojo.User;
import com.sunyujun.stool.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/16 20:26
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public int registerNormalUser(User user) {
        return registerMapper.registerNormalUser(user);
    }

    @Override
    public String searchForUsername(String username){
        return registerMapper.searchForUsername(username);
    }
}
