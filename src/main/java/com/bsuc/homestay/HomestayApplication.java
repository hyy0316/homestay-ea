package com.bsuc.homestay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bsuc.homestay.mapper")
public class HomestayApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomestayApplication.class, args);
    }

}
