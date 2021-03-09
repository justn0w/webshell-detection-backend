package com.detectwebshell;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author justnow
 * Created on 2021-03-07
 * Description
 */
@MapperScan("com.detectwebshell.mapper")
@SpringBootApplication
public class DetectionSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(DetectionSystemApplication.class, args);
    }
}
