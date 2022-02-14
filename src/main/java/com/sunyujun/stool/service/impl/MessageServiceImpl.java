package com.sunyujun.stool.service.impl;

import com.sunyujun.stool.mapper.MessageMapper;
import com.sunyujun.stool.pojo.Message;
import com.sunyujun.stool.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 2/14 19:44
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public int saveMessage(Message message) {
        return messageMapper.saveMessage(message);
    }

    @Override
    public List<Message> listMessages() {
        return messageMapper.listMessages();
    }
}
