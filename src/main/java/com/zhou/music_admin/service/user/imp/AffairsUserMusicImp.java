package com.zhou.music_admin.service.user.imp;

import com.zhou.music_admin.entity.userMusicBean.UserMusic;

import com.zhou.music_admin.service.ServletMapper;
import com.zhou.music_admin.service.user.AffairsUserMusic;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
@Service
public class AffairsUserMusicImp extends ServletMapper implements AffairsUserMusic {
    @Override
    public List<UserMusic> getSelUserMusic(String username) {
        List<UserMusic> selUserMusic = userMusicMapper.getSelUserMusic(username);
        return selUserMusic;
    }
    @Override
    public int deleteUserMusic(String username) {
        Example example = new Example(UserMusic.class);
        example.createCriteria().andEqualTo("username",username);
        int i = userMusicMapper.deleteByExample(example);
        return i;
    }
}
