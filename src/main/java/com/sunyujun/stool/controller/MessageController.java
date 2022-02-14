package com.sunyujun.stool.controller;

import com.sunyujun.stool.pojo.Message;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 2/14 19:22
 */
@RestController
public class MessageController {

    @PostMapping("/save_msg")
    public String saveMessage(@RequestBody Message message){


        return "success";
    }
}
