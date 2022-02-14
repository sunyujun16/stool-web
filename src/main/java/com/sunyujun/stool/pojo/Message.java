package com.sunyujun.stool.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 2/14 19:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer id;
    private String content;
    private Long time;
}
