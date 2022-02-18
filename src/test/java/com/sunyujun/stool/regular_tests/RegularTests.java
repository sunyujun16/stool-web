package com.sunyujun.stool.regular_tests;

import org.junit.jupiter.api.Test;

/**
 *
 * @author sunyujun
 * @version 0.0.0
 * @date 2/18 12:08
 */
public class RegularTests {

    // 这么基础的东西都不确定，电脑砸了吧，回家种地吧。。。草
    private void acceptVarArgs(String... args){
        System.out.println(args.getClass());
    }

    @Test
    void testVarArgs(){
        String[] args = {"123", "hahaha"};
        acceptVarArgs(args);
    }


}
