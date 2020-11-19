package com.zhou.music_admin.cache;

import com.zhou.music_admin.entity.musicBean.Music;
import com.zhou.music_admin.function.DateProcess;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Repository
@Slf4j
public class PublicsMusic {
   @Autowired
   private publicRedis publicRedis;
    @Resource
    DateProcess dateProcess;
    private static final Music m=new Music();
    public void  setCacheMuscic(String idps,Music muscic){
        ValueOperations redisTemplate = publicRedis.getRedisTemplate();
        redisTemplate.set(idps,muscic);
       log.info(dateProcess.toFormat(
               "yyyy年MM月dd日 HH时mm分SS秒#"
                       +this.getClass().getCanonicalName()
                       +"写入数据"));
    }
    public void setCacheMusicTime(String idps,Music music){
        ValueOperations redisTemplate = publicRedis.getRedisTemplate();
        redisTemplate.set(idps,music,20, TimeUnit.MINUTES);
        log.info(dateProcess.toFormat(
                "yyyy年MM月dd日 HH时mm分SS秒#"
                        +this.getClass().getCanonicalName()
                        +"写入数据"));
    }
    public Music getCaCheMusic(String idps){
        ValueOperations redisTemplate = publicRedis.getRedisTemplate();
        Music ms=(Music) redisTemplate.get(idps);
        ms=ms==null?m:null;
        return ms;

    }

}

