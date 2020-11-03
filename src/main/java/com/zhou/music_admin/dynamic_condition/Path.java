package com.zhou.music_admin.dynamic_condition;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * 路径配置器
 */
@Configuration
public class Path {
    @Bean("index")
    public String toIndex(){
        return "admin/index";
    }


}
