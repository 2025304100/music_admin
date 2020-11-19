package com.zhou.music_admin.cache;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

@Configuration
public class publicRedis {
    @Resource
     RedisTemplate redisTemplate;
    @Resource
     StringRedisTemplate stringRedisTemplate;

    public ValueOperations getRedisTemplate() {
        return redisTemplate.opsForValue();
    }

    public ValueOperations<String, String> getStringRedisTemplate() {
        return stringRedisTemplate.opsForValue();
    }
}
