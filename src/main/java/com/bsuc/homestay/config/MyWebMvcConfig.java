package com.bsuc.homestay.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Author： yyhuang
 * Date：2020/4/8 0008
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Value("${homestay.allowedOrigins}")
    private String[] allowedOrigins;
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .maxAge(1800)
                .allowedOrigins(allowedOrigins);
    }
}