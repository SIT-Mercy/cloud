package com.gallifrey.mercyhouse;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.gallifrey.mercyhouse.mapper")
@SpringBootApplication
public class MercyHouseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MercyHouseApplication.class, args);
    }

}
