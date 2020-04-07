//package com.bsuc.homestay.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.filter.DelegatingFilterProxy;
//
//import javax.servlet.DispatcherType;
//
///**
// * Author： yyhuang
// * Date：2020/4/7 0007
// */
//@Configuration
//public class ShiroConfig {
//    private Logger logger = LoggerFactory.getLogger(ShiroConfig.class);
//    //@Value 获取application.yml 文件的值
//    @Value("${spring.redis.host}")
//    private String jedisHost;
//
//    @Value("${spring.redis.port}")
//    private Integer jedisPort;
//
//    @Value("${spring.redis.password}")
//    private Integer jedisPassword;
//
//    @Bean
//    public FilterRegistrationBean delegationFilterProxy(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
//        proxy.setTargetFilterLifecycle(true);
//        proxy.setTargetBeanName("shiroFilter");
//        filterRegistrationBean.setFilter(proxy);
//        filterRegistrationBean.setDispatcherTypes(DispatcherType.ERROR,DispatcherType.REQUEST,DispatcherType.FORWARD,DispatcherType.INCLUDE);
//
//    }
//}
