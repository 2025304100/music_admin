package com.zhou.music_admin.service.music.imp;

import com.zhou.music_admin.dao.lyircBean.LyircMapper;
import com.zhou.music_admin.entity.lyircBean.Lyirc;
import com.zhou.music_admin.entity.mtypeBean.Mtype;
import com.zhou.music_admin.service.ServletMapper;
import com.zhou.music_admin.service.music.MusicLevel;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class MusicLevelImp extends ServletMapper implements MusicLevel {

    @Override
    public List<Lyirc> getAllMusicLevel() {
        List<Lyirc> lyircs = lyircMapper.selectAll();
        return lyircs;
    }

    @Override
    public Lyirc getOneMusicLevel(Integer id) {
        Lyirc lyirc = lyircMapper.selectByPrimaryKey(id);
        return lyirc;
    }

    @Override
    public Integer insertMusicLevel(Lyirc lyirc) {
        int insert = lyircMapper.insert(lyirc);
        return insert;
    }

    @Override
    public Integer deleteMusicLevel(Integer id) {
        int i = lyircMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public Integer updateMusicLevel(Lyirc old_Level,Lyirc level) {
        if (old_Level.toString().equals(level.toString())){
            return -2;
        }
        int i = lyircMapper.updateByPrimaryKey(level);
        return i;
    }
}
