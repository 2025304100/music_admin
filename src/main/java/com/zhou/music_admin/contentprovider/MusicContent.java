package com.zhou.music_admin.contentprovider;

import com.zhou.music_admin.cache.PublicsMusic;
import com.zhou.music_admin.cache.publicRedis;
import com.zhou.music_admin.entity.musicBean.Music;
import com.zhou.music_admin.entity.musicBean.MusicView;
import com.zhou.music_admin.security_module.encryption_model.Base64;
import com.zhou.music_admin.service.music.imp.musicControlImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Component
@Slf4j
public class MusicContent {
    @Resource
    private PublicsMusic ms;
    @Resource
    musicControlImp musicControlImp;
    private Music getMusic(String idps){
        Music caCheMusic = ms.getCaCheMusic(idps);
        //如果caChe的缓存为空从数据库调取
        if(ObjectUtils.isEmpty(caCheMusic)){
            //转换器  Base64-->index
            Integer id=Integer.valueOf(new String(idps.getBytes()));
            caCheMusic=musicControlImp.getOneIdMusic(id);

        }
        return caCheMusic;
    }
}
