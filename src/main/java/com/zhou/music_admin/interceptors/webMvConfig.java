package com.zhou.music_admin.interceptors;

import com.zhou.music_admin.interceptors.interior.user.Identity;
import com.zhou.music_admin.interceptors.interior.userFile;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class webMvConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new userFile())
                .addPathPatterns("/api/user/**");
        registry.addInterceptor(new Identity())
                .addPathPatterns("/api/user/identity/**");
    }
}
