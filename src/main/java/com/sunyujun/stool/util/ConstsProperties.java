package com.sunyujun.stool.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/17 18:36
 */
@ConfigurationProperties("spring.consts")
public class ConstsProperties {
    private String frontEndHost = "http://localhost:8081";


    public String getFrontEndHost() {
        return frontEndHost;
    }

    public void setFrontEndHost(String frontEndHost) {
        this.frontEndHost = frontEndHost;
    }
}
