package com.sunyujun.stool.mapper;

import com.sunyujun.stool.pojo.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 2/14 19:34
 */
@Mapper
public interface MessageMapper {

    @Insert("insert into message(content, `time`) values(#{content}, #{time}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveMessage(Message message);

    @Select("select * from message order by id desc")
    List<Message> listMessages();
}
