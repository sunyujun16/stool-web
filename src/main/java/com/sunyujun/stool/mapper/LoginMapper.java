package com.sunyujun.stool.mapper;

import com.sunyujun.stool.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/16 19:26
 */
@Mapper
public interface LoginMapper {

    User getUserByLogin(String userName, String passWord);
}
