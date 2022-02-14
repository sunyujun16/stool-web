package com.sunyujun.stool.service;

import com.sunyujun.stool.pojo.Message;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 2/14 19:43
 */
public interface MessageService {

    int saveMessage(Message message);

    List<Message> listMessages();
}
