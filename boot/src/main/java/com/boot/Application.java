package com.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Created by KaiLin.Guo on 2018-01-02.
 * MapperScan不必配置，会自动扫描当前目录下所有子目录
 */
@SpringBootApplication
//@MapperScan("com.boot.mapper.web.dao")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
