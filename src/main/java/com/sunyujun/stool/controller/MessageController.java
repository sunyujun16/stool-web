package com.sunyujun.stool.controller;

import com.sunyujun.stool.pojo.Message;
import com.sunyujun.stool.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 2/14 19:22
 */
@RestController
@CrossOrigin(origins = {"${spring.consts.front-end-host}"}, allowCredentials = "true")
public class MessageController {
    private static final Logger logger = LoggerFactory.getLogger(MessageController.class);

    @Autowired
    private MessageService messageService;

    @PostMapping("/save_msg")
    public String saveMessage(@RequestBody Message message) {
        int i = messageService.saveMessage(message);
//        logger.info("message的id: {}", message.getId());
        return i > 0 ? "success" : "fail";
    }

    @GetMapping("/list_messages")
    public List<Message> listMessages() {
        return messageService.listMessages();
    }
}
