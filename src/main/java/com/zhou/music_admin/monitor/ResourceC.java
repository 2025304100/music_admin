package com.zhou.music_admin.monitor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResourceC {
    @Bean(initMethod = "init")
    public Resource toExceptionResource(){
        return new Resource();
    }
}
