package com.pengfei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PengfeiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PengfeiApplication.class);
    }

}
