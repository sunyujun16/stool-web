package com.sunyujun.stool.config;

import com.sunyujun.stool.interceptor.LoginInterceptor;
import com.sunyujun.stool.util.ConstsProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/12 16:36
 */
@EnableConfigurationProperties(ConstsProperties.class)
@MapperScan("com.sunyujun.stool.mapper")
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 添加拦截器，并配置拦截路径
     *
     * @param registry 拦截器的注册器对象
     * @author sunyujun
     * @date 1/17
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加登录拦截，拦截所有，explicitly指定要放行的路径。至于静态资源部署在Nginx，此处不必操心。
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/register", "/check_dup_name",
                        "/save_msg", "/list_messages");
    }

    @Value("${spring.consts.front-end-host}")
    private String[] frontHosts;

    // 配置跨域
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(frontHosts)
                .allowCredentials(true);

    }
}
