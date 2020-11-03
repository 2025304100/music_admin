package com.zhou.music_admin.dao.musicBean;

import com.zhou.music_admin.entity.musicBean.Music;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MusicMapper extends Mapper<Music> {

    List<Music> getLinkMusic(String like,Integer prefix,Integer suffix);

    List<Music> getIndexMusic(Integer prefix,Integer suffix);
}