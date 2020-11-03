package com.zhou.music_admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.zhou.music_admin.dao.*")
@EnableFeignClients
@EnableAutoConfiguration
@ServletComponentScan
public class MusicAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicAdminApplication.class, args);
    }

}
