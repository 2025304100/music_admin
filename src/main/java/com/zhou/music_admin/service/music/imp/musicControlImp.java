package com.zhou.music_admin.service.music.imp;

import com.zhou.music_admin.entity.musicBean.Music;
import com.zhou.music_admin.service.ServletMapper;
import com.zhou.music_admin.service.music.musicControl;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class musicControlImp extends ServletMapper implements musicControl {

    @Override
    public List<Music> getAllMusic() {
        List<Music> music = musicMapper.selectAll();
        return music;
    }

    @Override
    public List<Music> getIndexMusic(Integer index) {
        List<Music> indexMusic = musicMapper.getIndexMusic((index - 1) * 20, index * 20);
        return indexMusic;
    }

    @Override
    public List<Music> getLikeMusic(Integer index,String like_key) {
        List<Music> linkMusic = musicMapper.getLinkMusic(like_key, (index - 1) * 20, index * 20);
        return linkMusic;
    }

    @Override
    public Music getOneIdMusic(Integer id) {
        Music music = musicMapper.selectByPrimaryKey(id);
        return music;
    }

    @Override
    public int upDateAuthorMusic(Music oldMusic,Music music) {
        if (oldMusic.toString().equals(music.toString())){
            return -2;
        }
        int i = musicMapper.updateByPrimaryKey(music);
        return i;
    }

    @Override
    public int insertMusic(Music music) {
        int insert = musicMapper.insert(music);
        return insert;
    }

    @Override
    public int deteleOneMusic(Integer id) {
        int i = musicMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int deteleAllMusic(String like_key) {
        return 0;
    }
}
