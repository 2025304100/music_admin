package com.zhou.music_admin.service.music;

import com.zhou.music_admin.entity.lyircBean.Lyirc;
import com.zhou.music_admin.entity.mtypeBean.Mtype;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MusicLevel {
     List<Lyirc> getAllMusicLevel();

     Lyirc getOneMusicLevel(Integer id);

     Integer insertMusicLevel(Lyirc lyirc);

     Integer deleteMusicLevel(Integer id);

     Integer updateMusicLevel(Lyirc old_Level,Lyirc level);
}
