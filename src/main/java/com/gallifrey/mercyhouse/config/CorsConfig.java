package com.gallifrey.mercyhouse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")//允许跨域访问路径
                .allowedOriginPatterns("*")
//                .allowedOrigins("*")// 允许跨域来源  springboot2.4之后弃
                .allowedMethods("POST","GET","PUT","OPTIONS","DELETE") //允许跨域方法
                .maxAge(168000) //预检测间隔时间
                .allowedHeaders("*") //允许头部设置
                .allowCredentials(true); //是否发送cookie
    }
}
