package com.greatech.server.rkg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.greatech.server"})
@ComponentScan(value = {"com.greatech.server", "com.greatech.server.rkg"})
@MapperScan({"com.greatech.server.rkg.dao", "com.greatech.server.rkg.repository"})
@EnableTransactionManagement
public class RKGApplication {

    public static void main(String[] args) {
        SpringApplication.run(RKGApplication.class, args);
    }

}
