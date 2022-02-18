package com.sunyujun.stool.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 2/18 11:16
 */
@Deprecated
//@Configuration
public class CorsConfig {

    @Value("${spring.consts.front-end-host}")
    private String[] frontHosts;

    @Bean
    public CorsConfiguration getStoolCorsConfig(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        for (String frontHost : frontHosts) {
            corsConfiguration.addAllowedOrigin(frontHost);
        }
        corsConfiguration.setAllowCredentials(true);
        return corsConfiguration;
    }

//    private CorsConfiguration buildConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        //  你需要跨域的地址  注意这里的 127.0.0.1 != localhost
//        // * 表示对所有的地址都可以访问
//        corsConfiguration.addAllowedOrigin("");
//        //  跨域的请求头
//        corsConfiguration.addAllowedHeader("*"); // 2
//        //  跨域的请求方法
//        corsConfiguration.addAllowedMethod("*"); // 3
//        //加上了这一句，大致意思是可以携带 cookie
//        //最终的结果是可以 在跨域请求的时候获取同一个 session
//        corsConfiguration.setAllowCredentials(true);
//        return corsConfiguration;
//    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //配置 可以访问的地址
        source.registerCorsConfiguration("/**", getStoolCorsConfig());
        return new CorsFilter(source);
    }
}
